package xb.posservice.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import net.sf.json.util.JSONUtils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import xb.posservice.service.ApiService;
//import xb.posservice.util.CodecUtil;
import xb.posservice.util.FileUtils;
import xb.posservice.util.JsonUtils;
import xb.posservice.util.SpringBeanUtils;
import xb.posservice.vo.APIEntity;

@Service("ApiServiceImpl")
public class ApiServiceImpl implements ApiService {

	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	Logger logger = Logger.getLogger("调用c#接口");

	// @Override
	public String sendRequest(String method, Map<String, String> parameters) {

		return send(method, parameters);
	}

	private String send(String method, Map<String, String> parameters) {
		APIEntity apiInfo = (APIEntity) SpringBeanUtils.getBean("apiInfo");

		StringBuffer urlBuffer = new StringBuffer();
		if (parameters.containsKey("ms")) {
			urlBuffer.append(apiInfo.getMsapiAddress() + method);
			parameters.remove("ms");
		} else {
			urlBuffer.append(apiInfo.getPosapiAddress() + method);
		}
		Map<String, String> postParams = new HashMap<String, String>();
		postParams = parameters;
		Date date = new Date();
		String time = format.format(date);

		if (parameters != null && !parameters.isEmpty()) {
			StringBuffer param = new StringBuffer();
			param.append(JsonUtils.hashMap2Json(parameters));
			// FileUtils.saveContent2File("D:/apache-tomcat-8/logs",
			// "log-"+time+".txt",
			// formatDate(System.currentTimeMillis())+method+"--------\n"+param.toString()+"\n");

		}
		try {
			String result = post(urlBuffer.toString(), postParams, apiInfo.getApiTimeout());
			System.out.print(result);
			try {
				Map<String, Object> resultMap = JsonUtils.json2Map(result);
				String code = (String) resultMap.get("code");
				if ("00".equals(code)) {
					String encodeData = (String) resultMap.get("data");

					return JsonUtils.object2Json(resultMap);
				} else {
					// FileUtils.saveContent2File("D:/apache-tomcat-8/logs",
					// "log-"+time+".txt",
					// formatDate(System.currentTimeMillis())+method+"--------\n"+result+"\n");
				}
			} catch (Exception e) {
				logger.error(e);
				// FileUtils.saveContent2File("D:/apache-tomcat-8/logs",
				// "log-"+time+".txt",
				// formatDate(System.currentTimeMillis())+method+"--------\n"+result+"\n");
			}

			return result;
		} catch (IOException e) {
			logger.error(e);
		} catch (GeneralSecurityException e) {
			logger.error(e);
		}
		return null;
	}

	private String post(String url, Map<String, String> parameters, int timeout)
			throws IOException, GeneralSecurityException {

		HttpClient client = url.startsWith("https") ? createSSLInsecureClient() : getHttpClient(true, timeout);

		StringBuffer responseHTML = new StringBuffer();
		BufferedReader in = null;

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		if (null != parameters) {
			for (Entry<String, String> ent : parameters.entrySet()) {
				formparams.add(new BasicNameValuePair(ent.getKey(), ent.getValue()));
			}
		}

		try {

			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");

			HttpPost postMethod = new HttpPost(url);
			postMethod.setEntity(entity);

			postMethod.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
			postMethod.addHeader(new BasicHeader("User-Agent", USER_AGENT));
			postMethod.addHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"));
			postMethod.addHeader(new BasicHeader("Accept-Language", "zh-CN"));
			// postMethod.addHeader(new BasicHeader("Content-Type",
			// "application/json"));

			HttpResponse response = client.execute(postMethod);

			String charset = EntityUtils.getContentCharSet(response.getEntity());
			if (charset == null) {
				charset = "UTF-8";
			}

			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), charset));
			String line = null;
			while ((line = in.readLine()) != null) {
				responseHTML.append(line + "\n");
			}
			if (null != in) {
				in.close();
			}
			return responseHTML.toString();

		} catch (IOException e) {
			throw e;
		} finally {

		}
	}

	private String formatDate(long currentTimestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(currentTimestamp));
	}

	/**
	 * 建立SSL连接
	 * 
	 * @return
	 * @throws GeneralSecurityException
	 */
	private CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

				// @Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}

				// @Override
				public void verify(String host, SSLSocket ssl) throws IOException {
				}

				// @Override
				public void verify(String host, X509Certificate cert) throws SSLException {
				}

				// @Override
				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
				}

			});
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (GeneralSecurityException e) {
			throw e;
		}
	}

	private HttpClient getHttpClient(boolean isRedirect, int timeout) {

		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		params.setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);

		params.setParameter("http.socket.timeout", timeout);
		params.setParameter("http.connection.timeout", timeout);
		params.setParameter("http.connection-manager.timeout", timeout);

		params.setParameter(ClientPNames.HANDLE_REDIRECTS, isRedirect);

		HttpProtocolParams.setUserAgent(params, USER_AGENT);

		HttpClient client = new DefaultHttpClient(cm, params);

		return client;
	}

	private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36";

	private static ThreadSafeClientConnManager cm = null;

	static {
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

		cm = new ThreadSafeClientConnManager(schemeRegistry);
		cm.setMaxTotal(100);
		cm.setDefaultMaxPerRoute(100);
	}
}

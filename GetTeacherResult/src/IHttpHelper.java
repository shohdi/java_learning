



public interface IHttpHelper
{
	String sendGet(String url,String cookieInfo) throws Exception;
	String sendPost(String url,String urlParameters,String cookieInfo) throws Exception;
	
}
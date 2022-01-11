public class BaseService {
private static final Logger =LoggerFactory.getLogger(BaseService.class);
  protected <T> ResponseEntity<String> callDownService(String methodName, String endPoint, HttpMethod method, Map<String, String> headers, T requestBody){
  ResponseEntity<String> response = null;
    headers.put("Authorization", wdpApiRestSecret.getWdpAuthHeaderValue());
    HttpHeaders requestHeaders = HeaderUtils.getHeaders(headers);
    HttpEntity<T> httpEntity;
    if(method == HttpMethod.GET){
    httpeEntity = new HttpEntity<>(requestHeaders)
      }else{
    httpeEntity = new HttpEntity<>(requestBody, requestHeaders)
    }
    try{
    response= wdpApiRestTemplate.exchange(endPoint,method, httpEntity, String.class)
      LoggerUtil.loglifeCycle(methodName, corrId, msgId, endPoint, requestHeader, requestBody, method.toString(), response, null,logEnabled)
      }catch(HttpStatusCodeException exec){
    LoggerUtil.loglifeCycle(methodName, corrId, msgId, endPoint, requestHeader, requestBody, method.toString(), response, null,logEnabled)
    }
    return response;
  }
} 

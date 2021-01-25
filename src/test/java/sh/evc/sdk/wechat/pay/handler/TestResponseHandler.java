package sh.evc.sdk.wechat.pay.handler;

import sh.evc.sdk.wechat.pay.response.ApiResponse;

/**
 * test response handler
 *
 * @author winixi
 * @date 2021/1/8 1:52 PM
 */
public class TestResponseHandler implements ResponseHandler {

  @Override
  public void append(ApiResponse response) {
    System.out.println(response.toString());
  }
}

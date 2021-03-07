package sh.evc.sdk.wechat.pay.response;

import sh.evc.sdk.wechat.pay.dict.ResultCode;
import sh.evc.sdk.wechat.pay.dict.ReturnCode;

/**
 * xml response
 *
 * @author winixi
 * @date 2021/1/18 3:48 PM
 */
public class XmlResponse extends ApiResponse {

  /**
   * 返回状态码
   * SUCCESS/FAIL
   * <p>
   * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
   */
  private ReturnCode returnCode;

  /**
   * 返回信息，如非空，为错误原因
   * <p>
   * 签名失败
   * 参数格式校验错误
   */
  private String returnMsg;

  /**
   * 业务结果
   * <p>
   * SUCCESS：分账申请接收成功，结果通过分账查询接口查询
   * FAIL ：提交业务失败
   */
  private ResultCode resultCode;

  /**
   * 错误代码
   * https://pay.weixin.qq.com/wiki/doc/api/allocation_sl.php?chapter=25_1&index=1
   */
  private String errCode;

  /**
   * 错误代码描述
   * 结果信息描述
   * 系统超时
   */
  private String errCodeDes;

  /**
   * 当err_code为PARAM_ERROR时，返回有误的请求参数字段名
   */
  private String errParam;

  /**
   * 业务是否成功
   *
   * @return
   */
  @Override
  public boolean isSuccess() {
    if (returnCode == ReturnCode.SUCCESS && resultCode == ResultCode.SUCCESS) {
      return true;
    }
    return false;
  }

  public ReturnCode getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(ReturnCode returnCode) {
    this.returnCode = returnCode;
  }

  public String getReturnMsg() {
    return returnMsg;
  }

  public void setReturnMsg(String returnMsg) {
    this.returnMsg = returnMsg;
  }

  public ResultCode getResultCode() {
    return resultCode;
  }

  public void setResultCode(ResultCode resultCode) {
    this.resultCode = resultCode;
  }

  public String getErrCode() {
    return errCode;
  }

  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  public String getErrCodeDes() {
    return errCodeDes;
  }

  public void setErrCodeDes(String errCodeDes) {
    this.errCodeDes = errCodeDes;
  }

  public String getErrParam() {
    return errParam;
  }

  public void setErrParam(String errParam) {
    this.errParam = errParam;
  }

  @Override
  public String toString() {
    return "XmlResponse{" +
            "returnCode=" + returnCode +
            ", returnMsg='" + returnMsg + '\'' +
            ", resultCode=" + resultCode +
            ", errCode='" + errCode + '\'' +
            ", errCodeDes='" + errCodeDes + '\'' +
            ", errParam='" + errParam + '\'' +
            "} " + super.toString();
  }
}

package sh.evc.sdk.wechat.pay;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.evc.sdk.wechat.pay.client.PayClient;
import sh.evc.sdk.wechat.pay.config.PayConfig;
import sh.evc.sdk.wechat.pay.config.TestConfig;
import sh.evc.sdk.wechat.pay.handler.ResponseHandler;
import sh.evc.sdk.wechat.pay.handler.TestResponseHandler;

/**
 * base test
 *
 * @author winixi
 * @date 2021/1/26 1:52 PM
 */
public class BaseTest {

  public final static Logger log = LoggerFactory.getLogger(BaseTest.class);
  public PayClient client;
  public PayConfig config = new TestConfig();
  public ResponseHandler handler = new TestResponseHandler();

  @Before
  public void before() {
    client = new PayClient(config, handler);
  }

}

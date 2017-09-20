package com.minlia.iot.plugin.brcb;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by will on 9/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BrcbCustomerServiceTestConfiguration.class,BrcbSettleTestConfiguration.class})
public abstract class BrcbAbstractTest {

  @Autowired
  protected BrcbCustomerServiceApi brcbCustomerServiceApi;

  @Autowired
  protected BrcbSettleApi brcbSettleApi;

  @Before
  public void setUp() throws Exception {
  }

}

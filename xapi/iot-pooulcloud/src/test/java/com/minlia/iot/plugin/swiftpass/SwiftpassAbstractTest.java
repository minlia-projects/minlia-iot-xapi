package com.minlia.iot.plugin.swiftpass;

import com.minlia.iot.plugin.pooulcloud.SwiftpassApi;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by will on 9/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SwiftpassTestConfiguration.class})
public abstract class SwiftpassAbstractTest {

  @Autowired
  protected SwiftpassApi swiftpassApi;


  @Before
  public void setUp() throws Exception {
  }

}

package com.minlia.iot.plugin.kuaidiniao;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by will on 9/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KuaidiniaoTestConfiguration.class})
public abstract class KuaidiniaoAbstractTest {

  @Autowired
  protected KuaidiniaoApi kuaidiniaoApi;


  @Before
  public void setUp() throws Exception {
  }

}

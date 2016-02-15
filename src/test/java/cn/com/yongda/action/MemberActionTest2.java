package cn.com.yongda.action;
/**
 * 
 */


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.meidusa.fastjson.JSONObject;

import cn.com.yongda.action.helloworld.SayHelloWorld;
import cn.com.yongda.action.request.HelloRequest;

/**
 * @author zhm
 *
 *         交易相关测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MemberActionTest2 {

    @Autowired
    private SayHelloWorld tradeAction;

    @Autowired
    protected WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testTradeQueryTest() throws Exception {
    	HelloRequest request = new HelloRequest();
        request.setName("张三");
        String json = JSONObject.toJSONString(request);
        MvcResult result = this.mockMvc
                .perform(
                        post("/hellworld/saygoodbye")
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(status().isOk())
                .andReturn();
        System.out.print(result.getResponse().getContentAsString());

    }

   
}

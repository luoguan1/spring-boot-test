package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private SolrClient client;

	@Test
	public void searchTest() {
		try {
			SolrQuery params = new SolrQuery();
			params.set("q", "传奇");
			params.setStart(0);
            params.setRows(20);
            params.set("df", "cat");
            //开启高亮
            params.setHighlight(true);
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");
            //solr数据库是 jcg
            QueryResponse queryResponse = client.query("jcg", params);
            SolrDocumentList results = queryResponse.getResults();
            long numFound = results.getNumFound();
            System.out.println(numFound);
            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("total", numFound);
            map.put("data", highlight);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getByIdTest() throws Exception {
		SolrDocument document = client.getById("jcg", "62071bc95e8c46a8bfb41f7218deec72");
		System.out.println(document);
	}

	@Test
	public void addSolrTest() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		try {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", uuid);
			doc.addField("cat", "创奇霸业");
			doc.addField("name", "新手礼包");
			doc.addField("price", "22.5");
			doc.addField("inStock", "不知道添啥");
			doc.addField("author", "罗冠");
			client.add("jcg", doc);
			client.commit("jcg");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private HttpSolrClient connetHttpSolrClientServer(String coreName){  
//        HttpSolrClient server = new HttpSolrClient(client + coreName);  
//        server.setSoTimeout(5000);   
//        server.setConnectionTimeout(1000);   
//        server.setDefaultMaxConnectionsPerHost(1000);   
//        server.setMaxTotalConnections(5000);  
//        return server;  
//    }  
}

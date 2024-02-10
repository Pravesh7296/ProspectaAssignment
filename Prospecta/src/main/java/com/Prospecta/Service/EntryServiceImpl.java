package com.Prospecta.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Prospecta.Model.Entry;
import com.Prospecta.Model.EntryList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EntryServiceImpl implements EntryServiceIntr{
    String baseUrl = "https://api.publicapis.org/entries";
	@Override
	public void saveEntry(Entry entry) {
		
		
	}
	@Override
	public List<Entry> ListOfEntryByCategory(String category) {
		// TODO Auto-generated method stub
		
	        RestTemplate restTemplate = new RestTemplate();
	      String res = restTemplate.getForObject(baseUrl, String.class);
	      List<Entry> entries= parseJsonResponse(res);
	    
	       
	        return entries;
	       
		
	        }
	private static List<Entry> parseJsonResponse(String jsonResponse) {
        List<Entry> entries = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode entriesNode = rootNode.get("entries");
           
            if (entriesNode != null && entriesNode.isArray()) {
                for (JsonNode entryNode : entriesNode) {
//                   Entry en = objectMapper.treeToValue(entryNode, Entry.class);
//                	entries.add(en);
                	String API = entryNode.get("API").toString();
                	String Description = entryNode.get("Description").toString();
                	Entry en = new Entry();
                	en.setAPI(API);
                	en.setDescription(Description);
                	entries.add(en);
//                   System.out.println( entryNode.get("API"));
//                   System.out.println( entryNode.get("Description"));
                   
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entries;
    }

	}

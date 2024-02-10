package com.Prospecta.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Prospecta.Model.Entry;
@Service
public interface EntryServiceIntr {
     public void saveEntry(Entry entry);
     public List<Entry> ListOfEntryByCategory(String category);
}

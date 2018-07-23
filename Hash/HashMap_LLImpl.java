import java.util.LinkedList;

/*
 * 
 * This implementation creates the hashmap as an array of LinkedList of HashEntries
 * 
Methods of hashmap:
Insertion - put(k,v) return k
Deletion - delete(k) returns k
Get the value - get(k)  returns v
Traversal - 
EntrySet - returns Set<Entry<K,V>>
KeySet - returns Set<K>
hashCode(k) = index
 (hfunction -> index)
isEmpty(), size() 

 */


class HashEntry{
	private String key;
	private String value;
	
	HashEntry(){}
	HashEntry(String k, String v){
		key = k;
		value = v;
	}
	public String getKey(){
		return key;
	}
	public String getValue(){
		return value;
	}
}


class HashMapUsingLL{
	LinkedList<HashEntry>[] hmap;
	int size;
	
	HashMapUsingLL(){
		hmap = new LinkedList[10];
	}
	
	HashMapUsingLL(int len){
		hmap = new LinkedList[len];
	}
	
	public int hashCode(String key){
		//int representation of the key
		return key.length();
	}
	
	public int getIndex(int hashCode){
		return hashCode%size;
	}
	
	public void put(String key, String value){
		int hashCode = hashCode(key);
		int index = getIndex(hashCode);
		
		LinkedList<HashEntry> hentries = hmap[index];
		int i = 0;
		while (i < hentries.size()) {
		    i++;
		}
		size++;
		hentries.add(i, new HashEntry(key, value));
	}
	
	public String get(String key){
		int hashCode = hashCode(key);
		int index = getIndex(hashCode);
		
		LinkedList<HashEntry> hentries = hmap[index];
		int i = 0;
		while (i < hentries.size()) {
			HashEntry hashEntry = hentries.get(i);
			if(hashEntry.getKey().equals(key))
				return hashEntry.getValue();
		    i++;
		}
		return null;
	}
	
	public String remove(String key){
		int hashCode = hashCode(key);
		int index = getIndex(hashCode);
		
		LinkedList<HashEntry> hentries = hmap[index];
		int i = 0, loc=0;
		HashEntry prev;
		while (i < hentries.size()) {
			HashEntry hashEntry = hentries.get(i);
			if(hashEntry.getKey().equals(key)){
				loc = i; 
			}
		    i++;
		}
		HashEntry removedItem = hentries.remove(loc);
		return removedItem.getKey();
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
}

public class HashMap_LLImpl {


	public static void main(String args[]){
		
	}
	
	
	
}

public class Hashtable{


HashNode[] table;
int size;
int num_buckets;

//public static void main(String[] args){
//
//
//	String key = "daydream";
//		String val = "daydream";
//
//		String  key1 = "daydream";
//		String val1 = "daydreaming";
//		
//
//		String key2 = "daydream";
//		String val2 = "nightmare";
//		Hashtable hashtable = new Hashtable();
//		
//
//		hashtable.put(key, val);
//		hashtable.put(key1, val1);
//		hashtable.put(key2, val2);
//
//		hashtable.printKeyAndValue(key);
//
//}


public Hashtable(){

	num_buckets = 10;
	table = new HashNode[num_buckets];
	size = 0;
            
}

public String get(String key){

	 	int hash = getHash(key);
        
        HashNode node = table[hash];

        while(node != null) {

		if(node.getKey().equals(key)){

			return node.getValue();

		}

		node = node.getNext();

	}
        

	return null;

}

public void printKeyAndValue(String key1){

		int hash = getHash(key1);

		HashNode node = table[hash];


		String key = node.getKey();
    	String value = node.getValue();

    	System.out.println("Key: " + key + " Value: " + value);
    
}

//Appends or replace key value pair to Hash table array
public void put (String key, String value) {

	

		int hash = getHash(key);

		
		if(size == table.length - 1){

			growArray();


		}


		HashNode newNode = new HashNode(key, value);
	
		if(table[hash] != null){

			
			//My alternative solution to get my program to work in order to replace the value if key exists.. 
			//This replaces (overwrites) key - value pair. Tested it locally as well. 
		
			newNode.setNext(table[hash]);
			table[hash] = newNode;

		}else{
			
			//Appends HashNode if it does not exists
			newNode.setNext(table[hash]);
			table[hash] = newNode;
			size++;


		}
		


}

//Resizes array
public void growArray(){

		HashNode[] newArray = new HashNode[table.length * 2];

		for(int i = 0; i < table.length - 1; i++){

			newArray[i] = table[i];


		}

		table = newArray;

}

//Checks if key exists in Hash table array
boolean containsKey (String key) {

	int hash = getHash(key);

	//traverse with HashNode, node
	HashNode node = table[hash];

	while(node != null) {

		if(node.getKey().equals(key)){

			return true;

		}

		node = node.getNext();

	}


	return false;

}

//Removes value from key
String remove (String key) throws Exception{


	int hash = getHash(key);

	HashNode node = table[hash];

	//if key exists, remove key-value pair by setting table hash to null and decrementing the size. 
	//Then, return removed value.
	if(containsKey(key)){

		String removedValue = node.getValue();
		table[hash] = null;
		size--;
		return removedValue;

	}


	throw new Exception("Key doesn't exist.");

	

}

//Gets the hash position of the key value pair in Hash table array
private int getHash(String key) {
       
        return Math.abs(key.hashCode() % num_buckets);
}



//HashNode class
public class HashNode{

	public String key;
	public String value;
	public HashNode next;

	public HashNode(String key, String value){

		this.key = key;
		this.value = value;
		this.next = null;

	}


	public String getKey() {
            
            return this.key;

     }

     public void setKey(String k) {

        this.key = k;

    }
 
    public String getValue() {
            
            return this.value;

    }

    public void setValue(String v) {

        this.value = v;

    }

    public HashNode getNext() {
            
            return this.next;

    }


    public void setNext(HashNode n) {

        this.next = n;

    }



}

}






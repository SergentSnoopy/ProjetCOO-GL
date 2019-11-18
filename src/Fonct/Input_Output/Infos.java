package Fonct.Input_Output;

import java.util.ArrayList;

public class Infos extends ArrayList<ArrayList<String>>{
//	public static interface Writable<T>{
//		public String parse(T e);
//		public default ArrayList<String> toList(ArrayList<T> l){
//			ArrayList<String> out = new ArrayList<String>();
//			for(T e : l)
//				out.add(this.parse(e));
//			return out;
//		}
//	}
	
	public static abstract class Writable<T>{
		private ArrayList<T> list;
		
		public Writable(ArrayList<T> l) {
			this.list = l;
		}
		
		public abstract String parse(T e);
		public byte[] getData(){
			String out = "";
			for(T e : this.list)
				out += this.parse(e) + '\n';
			return out.getBytes();
		}
	}
}

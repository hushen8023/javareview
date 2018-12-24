package com.hushen.datastructure.string;

public class ArrayStr implements Str {
	private int len;
	private char[] s;
	
	public ArrayStr() {
		len = 0;
		//s = new char[0];
	}
	
	public ArrayStr(char[] ch) {
		len = ch.length;
		s = ch;
	}
	
	public ArrayStr(Str s) {
		len = s.length();
		for(int i=0; i<len; i++) {
			this.s[i] = s.charAt(i);
		}
	}
	
	public ArrayStr(String str) {
		len = str.length();
		s = new char[len];
		for(int i=0; i<len; i++) {
			s[i] = str.charAt(i);
		}
	}
 
	public char charAt(int index) {
		if(index <0 || index > len) {
			throw new StringIndexOutOfBoundsException(index);
		}
		return s[index];
	}
 
	public int compareTo(Object o) {
		Str s2 = (Str)o;
		int n = Math.min(len, s2.length());
		int i = 0;
		while(i<n) {
			char c1 = s[i], c2 = s2.charAt(i);
			if(c1 != c2) {
				return c1-c2;				
			}
			i++;
		}
		return len - s2.length();
	}
 
	public Str concat(Str str) {
		int n = len + str.length();
		expand(n);
		for(int i=0; i<str.length(); i++) {
			s[i+len] = str.charAt(i);
		}
		len = n;
		return this;
	}
 
	public Str delete(int begin, int end) {
		int n = end-begin;
		char[] c = new char[n];
		for(int i=end; i<len; i++) {
			s[i-n] = s[i];
		}
		len = len-n;
		return this;
	}
 
	private void expand(int size) {
		char c[] = new char[size];
		for(int i=0; i<len; i++) {
			c[i] = s[i];
		}
		s = c;
	}
 
	public int indexOf(char c) {
		return indexOf(c, 0);
	}
 
	public int indexOf(char c, int from) {
		int i = from;
		while(i<len) {
			if(c == s[i])
				return i;
			i++;
		}
		return -1;
	}
 
	public int indexOf(Str str) {
		return indexOf(str, 0);
	}
 
	public int indexOf(Str str, int from) {
		int i = from, j = 0;
		int sLen = str.length();
		while((i<len) && (j<sLen)) {
			if(s[i] == str.charAt(j)) {
				i++;
				j++;
			} else {
				i = i-j+1;
				j = 0;
			}
		}
		if(j == sLen)
			return i-sLen;
		else 
			return -1;
	}
	
	public Str insert(int pos, Str str) {
		char c[] = null;
		if(pos < 0 || pos > len) {
			throw new StringIndexOutOfBoundsException(pos);
		} else {
			Str s2 = this.substring(pos);
			delete(pos, len);
			concat(str);
			concat(s2);
		}
		return this;
	}
 
	public int length() {
		return len;
	}
	
	public Str replace(Str target, Str replacement) {
		return replace(target, replacement, 0);
	}
	
	
 
	public Str replace(Str target, Str replacement, int from) {
		int tLen = target.length();
		int rLen = replacement.length();
		int pos, k = 0;
		while(k<len) {
			pos = this.indexOf(target, from);
			if(-1 == pos) {
				break;
			} else {
				delete(pos, pos+tLen);
				insert(pos, replacement);
				k = pos + rLen;
			}
		}
		return this;
	}
 
	public Str substring(int strartIndex) {
		return substring(strartIndex, len);
	}
 
	public Str substring(int beginIndex, int endIndex) {
		int n = endIndex - beginIndex;
		char ss[] = new char[n];
		for(int i=0; i<n; i++) {
			ss[i] = s[i+beginIndex];
		}
		return new ArrayStr(ss);
	}
 
	public char[] toCharArray() {
		return s;
	}
 
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<len; i++) {
			sb.append(s[i]);
		}
		return sb.toString();
	}
}

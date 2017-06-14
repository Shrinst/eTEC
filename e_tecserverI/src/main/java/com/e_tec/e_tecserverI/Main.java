package com.e_tec.e_tecserverI;

import java.util.ArrayList;
import java.util.List;

import com.e_tec.e_tecserverI.model.Client;
import com.e_tec.e_tecserverI.model.Product;
import com.e_tec.e_tecserverI.sortalgorithms.Bubble_sort;
import com.e_tec.e_tecserverI.sortalgorithms.Selection_sort;
import com.e_tec.e_tecserverI.xml.parser.XMLParserClient;
import com.e_tec.e_tecserverI.xml.parser.XMLParserProduct;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterClient;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterProduct;

public class Main {

	public static void main(String[] args) {
		String[] hola = {"1", "2", "3", "6", "4", "8"};
		String[] hola2 = Selection_sort.sortStringA(hola);
		
		for (String i : hola2) {
			System.out.println(i);
		}
		
	}
}

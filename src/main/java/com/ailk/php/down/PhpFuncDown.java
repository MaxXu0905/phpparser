package com.ailk.php.down;

import java.io.File;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;

public class PhpFuncDown {
	public static void main(String[] args)  throws Exception {
       Parser parser = new Parser("assets/source/left.html");
       parser.setEncoding("UTF-8");
       parser.extractAllNodesThatMatch(new NodeFilter() {
			@Override
			public boolean accept(Node node) {
				try{
					if("a href=\"funcref.html\"".equals(node.getText())){
						Node parent = node.getParent();
						NodeList pa = parent.getChildren();
						NodeList allClasses = pa.elementAt(2).getChildren();
						for(int i = 1; i< allClasses.size(); i++){
							Node cls = allClasses.elementAt(i);
//							System.out.println(cls.getChildren().elementAt(0).getChildren().elementAt(0).getText()); //txt
							String txt = cls.getChildren().elementAt(0).getText(); 
							System.out.println(cls.getChildren().elementAt(0).getText());
							String className = txt.substring(txt.indexOf("=\"") + 6, txt.lastIndexOf(".html"));
							System.out.println(className);
							File forder = new File("assets/source/" + className);
							if(!forder.exists()){
								forder.mkdirs();
							}
							NodeList allFuns =  cls.getChildren().elementAt(2).getChildren();
						   for(int index = 1 ; index < allFuns.size();index++){
							   Node fun =  allFuns.elementAt(index);
							   String hrefTxt = fun.getChildren().elementAt(0).getText();
							   String fileName = hrefTxt.substring(hrefTxt.indexOf("=\"") + 2,hrefTxt.lastIndexOf("\"") ); 
							   System.out.println(fileName);
							   try{
								   HttpDownUtils.downFile(new File("assets/source/" + className +"/" + fileName), "http://php.jz123.cn/" + fileName);
							   }catch(Exception e2){
								   e2.printStackTrace();
							       System.out.println("down file error " + e2.getMessage());
							       continue;
							   }
						   }
						}
						System.out.println(pa.size());                
					}
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("error down func " + e.getMessage());
				}
				return true;
			}
		});
	}
	
}

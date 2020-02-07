package com.ssafy;

import java.util.Arrays;

public class ProductMgr {
	
	Product []products;
	
	public ProductMgr() {
	  //상품정보(TV와 Refrigerator)를 객체 배열을 활용하여 저장
	  products = new Product[5];
	  
	  //상품객체정의
	  TV tv1 = new TV();
	      tv1.setProductNum("QN1004");
	      tv1.setProductName("삼성시리즈Q");
	      tv1.setPrice(1180000);
	      tv1.setAmount(30);
	      tv1.setInch(65);
	      tv1.setDisplayType("LED");    
      TV tv2 = new TV("UH2004", "유맥스", 750000, 20 , 55, "LED");
      
      //상품저장(입력)
      products[0]= tv1;
      products[1]= tv2;
      
      //상품객체정의와 저장(입력)
      //String productNum, String productName, int price, int amount, int liter
      products[2]= new Refrigerator("RF3004","삼성비스포크",2200000,30,871);
      products[3]= new Refrigerator("ST4004","엘지디오스",1600000,20,821);
      products[4]= new Refrigerator("WK5004","대우클라쎄",350000,10,144);
	}
	
	//상품정보 전체를 검색하는 기능
	public Product[] searchProductAll() {
		return products;
	}
	
	//상품번호로 상품을 검색하는 기능
	public Product searchByProductNum(String productNum) {
		String productNo;
		for (int i = 0; i < products.length; i++) {
			productNo=products[i].getProductNum();
		    if(productNo.equals(productNum))
		    	return products[i];
		}
		return null;
	}
	
	//상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
    public String searchByProductName(String productName) {
    	String productStr="";
    	for (int i = 0; i < products.length; i++) {
		    if(products[i].getProductName().contains(productName))
		    	productStr+=products[i]+"\r\n";
		}
		return productStr;
	}
    
    //TV정보만 검색
    public String searchKindTV() {
    	String productStr="";
    	for (Product product: products) {
		    if(product instanceof TV)
		    	productStr+=product.toString()+"\r\n";
		}
		return productStr;
    }
    
    //Refrigerator만 검색
    public String searchKindRefrigerator() {
    	String productStr="";
    	for (Product product: products) {
		    if(product instanceof Refrigerator)
		    	productStr+=product.toString()+"\r\n";
		}
		return productStr;
    }
    
    //상품번호로 상품을 삭제하는 기능
    public void removeByProductNo(String productNum) {
		for (int i=0; i<products.length; i++) {
			
		    if(products[i].getProductNum().equals(productNum)) {
		    	//products[i]=null; 일치하는 상품 삭제
		    	
                for(;i<products.length-1; i++) { //삭제된 상품의 우측상품을 왼쪽shift하기
		    	   products[i] = products[i+1];	
                }
                products= Arrays.copyOf(products, products.length-1);
                //삭제된 상품을 반영한 새로운 배열 객체 정보얻기
		    }
		}
	}
    
    //전체 재고 상품 금액을 구하는 기능
    public int inventoryAmount() {
    	int total=0;
    	for (Product product: products) {
		     total += product.getPrice() *product.getAmount();
		}
		return total;
    }

}

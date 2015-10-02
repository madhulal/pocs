import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class Register{
	
	static inject = [HttpClient,Validation];
	constructor(http,validation){
		this.productCategory='';
		this.productCompany='';
		this.productName='';
		this.ProductModel={};
		this.http=http;
	}
	createProduct()
	{
		 this.ProductModel.id='';
		 this.ProductModel.productCategory=this.productCategory;
		 this.ProductModel.productCompany=this.productCompany;
		 this.ProductModel.productName=this.productName;
		 this.http.createRequest('/store/rest/Product')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.ProductModel)
        .send()
        .then( response => { 
        	this.ProductModel=response.content;	
        })
        .catch( error=>{console.log("erroroccured")});

}
}

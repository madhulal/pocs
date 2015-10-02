
import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class ProductSearch
{
	static inject = [HttpClient,Validation];
	constructor(http,validation)
	{
		this.http=http;
		this.category='';
		this.categoryList=[];
	}
	
	getCategoryWiseList()
	{
		 this.url="/store/rest/ProductSearch/"+this.category;
		 this.http.get(this.url).then( response => {
		 this.ProductSearch=response.content;
		 console.log("list value"+this.ProductSearch)
		      }); 

	}
	getCategoryList()
	{
		this.http.createRequest('/store/rest/Categories')
	       .asGet()
	       .withHeader('Content-Type','application/json')
	       .withParams()
	       .send()
	       .then( response => { 
	       	
	        this.categoryList=response.content;	
	        
	       	
	       });

	}
}
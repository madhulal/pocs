import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class Register{
	
	
	static inject = [HttpClient,Validation];
	constructor(http,validation){
		this.userName='';
		this.password='';
		this.firstName='';
		this.middleName='';
		this.lastName='';
		this.contactNumber='';
		this.contactNumbers=new Map();
		this.UserModel={};
		this.http=http;
		
    	// applying validation
    	this.validation = validation.on(this)
	    .ensure('userName')
	    	  .isNotEmpty()
	    	  .containsOnlyAlphanumerics()
	          .hasMinLength(2)
	          .hasMaxLength(5)
	    .ensure('password')
	    	.isNotEmpty()
	    	  .containsOnlyAlphanumerics()
	          .hasMinLength(2)
	          .hasMaxLength(5)
	    .ensure('firstName')
	    	  .isNotEmpty()
	    	  .containsOnlyAlphanumerics()
	          .hasMinLength(2)
	          .hasMaxLength(5)
	     .ensure('middleName')
	    	  .isNotEmpty()
	    	  .containsOnlyAlphanumerics()
	          .hasMinLength(2)
	          .hasMaxLength(5)
	     .ensure('lastName')
	    	  .isNotEmpty()
	    	  .containsOnlyAlphanumerics()
	          .hasMinLength(2)
	          .hasMaxLength(5)
	     
	}
	createUser()
	{
		
	
		 this.UserModel.userId='';
		 this.UserModel.userName=this.userName;
		 this.UserModel.passWord=this.passWord;
		 this.UserModel.firstName=this.firstName;
		 this.UserModel.middleName=this.middleName;
		 this.UserModel.lastName=this.lastName;
		 this.UserModel.contactNumbers=this.contactNumbers;
		 
		 this.http.createRequest('/store/rest/Users')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.UserModel)
        .send()
        .then( response => { 
        	
        	this.UserModel=response.content;	
        	
        });
        	
	}
	
	
	
	
	
	
	
}
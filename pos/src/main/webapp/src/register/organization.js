import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class Register{
	
	static inject = [HttpClient,Validation];
	constructor(http,validation){
		
		this.Organization={};
		this.name='';
		this.emailId='';
		this.address={addressLine1:'',addressLine2:'',addressLine3:'',city:'',state:'',post:'',country:''};
		this.contactNumber={contactNumber1:'',contactNumber2:'',contactNumber3:''};
		this.http=http;
	}
	registerOrganization()
	{
		this.Organization.id='';
		this.Organization.name=this.name;
		 this.Organization.emailId=this.emailId;
		 this.Organization.address=this.address;
		 this.Organization.contactNumber=this.contactNumber;
		 console.log(this.Organization);
	 this.http.createRequest('/store/rest/Organization')
       .asPost()
       .withHeader('Content-Type','application/json')
       .withContent(this.Organization)
       .send()
       .then( response => { 
       //	this.Organization=response.content;	
       })
       .catch( error=>{console.log("erroroccured")});
	}
}
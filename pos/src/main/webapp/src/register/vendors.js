import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class Register{
	static inject = [HttpClient,Validation];
	constructor(http,validation){
		
		this.Vendors={};
		this.name='';
		this.emailId='';
		this.address={addressLine1:'',addressLine2:'',addressLine3:'',city:'',state:'',post:'',country:''};
		this.contactNumber={contactNumber1:'',contactNumber2:'',contactNumber3:''};
		this.http=http;
	}
	registerVendors()
	{
		 //this.Vendors.id='';
		 this.Vendors.name=this.name;
		 this.Vendors.emailId=this.emailId; 
		 this.Vendors.address=this.address;
		 this.Vendors.contactNumber=this.contactNumber;
		 console.log(this.Vendors);
		 this.http.createRequest('/store/rest/Vendors')
      .asPost()
      .withHeader('Content-Type','application/json')
      .withContent(this.Vendors)
      .send()
      .then( response => { 
      //	this.Organization=response.content;	
      })
      .catch( error=>{console.log("erroroccured")});
	}
	
		
		
}
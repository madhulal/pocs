import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class Register{
	static inject = [HttpClient,Validation];
	constructor(http,validation){
		this.Manufactures={};
		this.name='';
		this.emailId='';
		this.address={addressLine1:'',addressLine2:'',addressLine3:'',city:'',state:'',post:'',country:''};
		this.contactNumber={contactNumber1:'',contactNumber2:'',contactNumber3:''};
		this.http=http;
	}
	registerManufactures()
	{
			this.Manufactures.userId='';
			this.Manufactures.name=this.name;
		 this.Manufactures.emailId=this.emailId;
		 this.Manufactures.address=this.address;
		 this.Manufactures.contactNumber=this.contactNumber;
		 this.http.createRequest('/store/rest/Manufactures')
      .asPost()
      .withHeader('Content-Type','application/json')
      .withContent(this.Manufactures)
      .send()
      .then( response => { 
      //	this.Organization=response.content;	
      })
      .catch( error=>{console.log("erroroccured")});
	}
	
}
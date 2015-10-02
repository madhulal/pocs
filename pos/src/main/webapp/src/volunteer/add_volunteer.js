import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class AddVolunteer{
	static inject = [HttpClient,Validation];
	heading="Add New Volunteer ";
	volunteerUserName='';
	volunteerPassword='';
	volunteerEmail='';
	volunteerMobileNumber='';
	volunteerName='';
    volunteer={};
    
    status={title:'',message:''}
    	constructor(http,validation)
    	{
    		this.http=http;
    		this.currentVolunteer={};
    		this.validation =validation
    		//applying validation
        	this.validation =this. validation.on(this)
		    .ensure('volunteerUserName')
		    	  .isNotEmpty()
		    	  .containsOnlyAlphanumerics()
		          .hasMinLength(3)
		    .ensure('volunteerPassword')
		    	   .isNotEmpty()
		    	  .containsOnlyAlphanumerics()
		          .hasMinLength(4)
		    .ensure('volunteerEmail') 
		    	  .isNotEmpty()
		     .ensure('volunteerMobileNumber') 
		          .isNotEmpty()
		          .hasMinLength(10)
		          .hasMaxLength(10) 
		    .ensure('volunteerName') 
		          .isNotEmpty()
		          .hasMinLength(3)
		          .hasMaxLength(10) ;
    		this.validation2 =validation
    		//applying validation
        	this.validation2 =this. validation2.on(this)
		    .ensure('currentVolunteer.volunteerUserName')
		    	  .isNotEmpty()
		    	  .containsOnlyAlphanumerics()
		          .hasMinLength(3)
		    .ensure('currentVolunteer.volunteerPassword')
		    	   .isNotEmpty()
		    	  .containsOnlyAlphanumerics()
		          .hasMinLength(4)
		    .ensure('currentVolunteer.volunteerEmail') 
		    	  .isNotEmpty()
		     .ensure('currentVolunteer.volunteerMobileNumber') 
		          .isNotEmpty()
		          .hasMinLength(10)
		          .hasMaxLength(10) 
		    .ensure('currentVolunteer.volunteerName') 
		          .isNotEmpty()
		          .hasMinLength(3)
		          .hasMaxLength(10) ;
    		this.getAllVolunteer()
    	}
    searchVolunteer()
    {
    	this.volunteerPassword='';
   	 	this.volunteerEmail='';
   	 	this.volunteerMobileNumber='';
   	 	this.volunteerName='';
    	this.status.title='';
		this.status.message='';
		if(this.volunteerUserName!=''){
			
			this.http.createRequest('/store/rest/volunteer/search')
	        .asPost()
	        .withHeader('Content-Type','application/json')
	        .withContent(this.volunteerUserName)
	        .send()
	        .then( response => { 
	
	       	 this.volunteer = response.content;
	    	 this.volunteerPassword=this.volunteer.volunteerPassword;
	    	 this.volunteerEmail=this.volunteer.volunteerEmail;
	    	 this.volunteerMobileNumber=this.volunteer.volunteerMobileNumber;
	    	 this.volunteerName=this.volunteer.volunteerName;
	    	
	        	
	        });
		}
    	
    }
	add_volunteer()
	{
		this.volunteer.volunteerUserName=this.volunteerUserName;
		this.volunteer.volunteerPassword=this.volunteerPassword;
		this.volunteer.volunteerName=this.volunteerName;
		this.volunteer.volunteerMobileNumber=this.volunteerMobileNumber;
		this.volunteer.volunteerEmail=this.volunteerEmail;
	
		//this.volunteer={volunteerUserName:'sdfs',volunteerPassword:'gjthr',volunteerName:'htrh',volunteerMobileNumber:'rtherhe',volunteerEmail:'dgfsd'}
		console.log(this.volunteer)
		this.http.createRequest('/store/rest/volunteer/add')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.volunteer)
        .send()
        .then( response => { 
        	
        	this.status=response.content;	
        	console.log("working fyn"+this.status)
        	this.getAllVolunteer();
        });
	}
	getAllVolunteer()
	{
		this.http.get('/store/rest/volunteer/all').then( response => {
	        this.volunteers = response.content;
	        console.log( 'response'+ this.volunteers);
	      });
	}

	deleteVolunteer(volunteer)
	{
		this.currentVolunteer=volunteer;
		
	}
	deleteVolunteerOk()
	{
		this.volunteer.volunteerId=this.currentVolunteer.volunteerId;
		this.volunteer.volunteerUserName=this.currentVolunteer.volunteerUserName;
		this.volunteer.volunteerPassword=this.currentVolunteer.volunteerPassword;
		this.volunteer.volunteerName=this.currentVolunteer.volunteerName;
		this.volunteer.volunteerMobileNumber=this.currentVolunteer.volunteerMobileNumber;
		this.volunteer.volunteerEmail=this.currentVolunteer.volunteerEmail;
		console.log(this.volunteer)
		this.http.createRequest('/store/rest/volunteer/delete')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.volunteer)
        .send()
        .then( response => { 
        	
        	this.status=response.content;	
        	console.log("working fyn"+this.status)
        	this.getAllVolunteer();
        });
		
	}
	editVolunteer(volunteer)
	{
		this.status='';
		this.currentVolunteer=volunteer;
	
	}
	editVolunteerOk()
	{
		this.volunteer.volunteerId=this.currentVolunteer.volunteerId;
		this.volunteer.volunteerUserName=this.currentVolunteer.volunteerUserName;
		this.volunteer.volunteerPassword=this.currentVolunteer.volunteerPassword;
		this.volunteer.volunteerName=this.currentVolunteer.volunteerName;
		this.volunteer.volunteerMobileNumber=this.currentVolunteer.volunteerMobileNumber;
		this.volunteer.volunteerEmail=this.currentVolunteer.volunteerEmail;
		console.log(this.volunteer)
		 this.http.createRequest('/store/rest/volunteer/updateInfo')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.volunteer)
        .send()
        .then( response => { 
        	
        	this.status=response.content;	
        	console.log("working fyn"+this.status)
        	this.getAllVolunteer();
        });
		
	}
}
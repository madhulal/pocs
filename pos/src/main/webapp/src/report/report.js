import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
export class DailyReport{
	static inject = [HttpClient,Validation];
	constructor(http,validation)
	{
		this.http=http;
		this.validation =validation
		this.heading="Report";
		this.date='';
		this.date1=[];
		
		this.today = new Date();
		this.dd = this.today.getDate();
		this.mm = this.today.getMonth()+1; 
		this.yyyy = this.today.getFullYear();
		this.Payments1=[];
		this.Payments2=[];
		this.Payments3=[];
		this.Payments4=[];
		this.validation =this. validation.on(this)
	    .ensure('date')
	    	  .isNotEmpty()
	    	  .matches(/^\d{4}\/\d{2}\/\d{2}$/)       //.matches(/^\d{2}\/\d{2}\/\d{4}$/)
	    .ensure('date1[]')
	    	  .isNotEmpty()
	    	  .matches(/^\d{4}\/\d{2}\/\d{2}$/)
	     .ensure('date1[1]')
	    	  .isNotEmpty()
	    	  .matches(/^\d{4}\/\d{2}\/\d{2}$/)	  
	    .ensure('mm')
	    	  .isNotEmpty()
	    	  .matches(/^\d{2}$/)
	    .ensure('yyyy')
	    	  .isNotEmpty()
	    	  .matches(/^\d{4}$/);
	    	  
	}
	activate(){
		this.date=this.fullDate;
		this.getAllPaymentsByDate()
	}
	getAllPaymentsByDate()
	{
		this.http.createRequest('/store/rest/patient/dailyReport')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.date)
        .send()
        .then( response => { 
        	
        	this.Payments1=response.content;	
        	
        });
	}
	getAllPaymentsByMonth()
	{
		this.http.createRequest('/store/rest/patient/monthlyReport')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.mm)
        .send()
        .then( response => { 
        	console.log("workingggg month")
        	this.Payments2=response.content;	
        	console.log(this.Payments2) 
        });
	}
	getAllPaymentsByYear()
	{
		this.http.createRequest('/store/rest/patient/yearlyReport')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.yyyy)
        .send()
        .then( response => { 
        	console.log("workingggg year")
        	this.Payments4=response.content;	
        	console.log(this.Payments4) 
        });
	}
	getAllPaymentsByCustom(){
		this.http.createRequest('/store/rest/patient/customReport')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.date1)
        .send()
        .then( response => { 
        	console.log("workingggg month")
        	this.Payments3=response.content;
        });
	}
	
	get fullDate()
	{
		if(this.dd.toString().length<2){
			this.dd='0'+this.dd
	    } 
	    if(this.mm.toString().length<2){
	    	this.mm='0'+this.mm
	    }
	   // var date= this.dd+'/'+this.mm+'/'+this.yyyy;
	    var date=  this.yyyy+'/'+this.mm+'/'+this.dd;
	   
	    this.date1=[date,date];
	     return date;
	}
	getTotal(Payments){
		var total=0;
		for(var i=0;i<Payments.length;i++)
			{
			total=total+Payments[i].paymentAmount;
			}
		return total;
	}
}


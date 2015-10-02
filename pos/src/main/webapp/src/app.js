import 'bootstrap';
import 'bootstrap/css/bootstrap.css!';

export class App {
  configureRouter(config, router){
    config.title = 'Asraya ';
    config.map([
      { route: ['','home'],  moduleId: './home/home',      nav: false, title:'home' },
      /*{ route: 'patient',        moduleId: './patient/patient',       nav: true, title:'All Patients' },
	  { route: 'register',        moduleId: './payment/payment',       nav: true, title:'Payment' },
	  { route: 'add_volunteer',        moduleId: './volunteer/add_volunteer',       nav: true, title:'AddVolunteer' },
	  { route: 'daily_report',        moduleId: './report/report',       nav: true, title:'Report' },
	  { route: 'graph',        moduleId: './graph/display_graph',       nav: true, title:'Graph' },
	  { route: 'details/:id',        moduleId: './patient/details',        name:'details' },
	  { route: 'register_user',        moduleId: './register/register',  nav: true   ,   title:'RegisterUser' },*/
	  { route: 'Organization',        moduleId: './register/organization',  nav: true   ,   title:'Register Organization' },
	  { route: 'Manufactures',        moduleId: './register/manufactures',  nav: true   ,   title:'Register Manufactures' } ,
	  { route: 'Vendors',        moduleId: './register/vendors',  nav: true   ,   title:'Register Vendors' } ,
	  { route: 'Purchase',        moduleId: './purchase/purchase',  nav: true   ,   title:'Purchase' } ,
	  { route: 'register_product',        moduleId: './register/product',  nav: true   ,   title:'Register Product' }, 
	  { route: 'product_search_result',        moduleId: './report/product_search',  nav: true   ,   title:'Search Product' } 
      //{ route: 'child-router',  moduleId: './child-router', nav: true, title:'Child Router' }
    ]);

    this.router = router;
  }
  
}

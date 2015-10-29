import {Component, bootstrap} from 'angular2/angular2';
import {Http, HTTP_PROVIDERS} from 'angular2/http';
import {JSONP_PROVIDERS, Jsonp} from 'angular2/http';
@Component({
    selector: 'my-app',
    bindings: [HTTP_PROVIDERS],
    template: '<div>My name is {{name}}</div>'+
    '<div>' +
    '<input #newname type="text"> ' +
    '<button (click)="changeName(newname.value)" >Change name </button> </div>'
})
class AppComponent {
    name;
    subjects;
    constructor(http:Http) {
        this.name = "Vadim";
        http.get("/subjects").subscribe((res:Response) => this.subjects = res.json());
    }

    changeName(newName){
        this.name=newName;
        alert(this.subjects[0].name);
    }
}
bootstrap(AppComponent);

function AppComponent() {}
AppComponent.annotations = [
    new angular.ComponentAnnotation({
        selector: 'my-app'
    }),
    new angular.ViewAnnotation({
        template: '<h1>Hello guest!</h1>'
    })
];
document.addEventListener('DOMContentLoaded', function() {
    angular.bootstrap(AppComponent);
});

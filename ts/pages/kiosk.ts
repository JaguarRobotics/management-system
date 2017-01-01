/// <reference path="../page.ts" />
/// <reference path="../navigation.ts" />
/// <reference path="../apis.ts" />

namespace org.usd232.robotics.management.pages {
    import ApiController = org.usd232.robotics.management.apis.ApiController;
    import LoginRequest = org.usd232.robotics.management.apis.LoginRequest;

    export class KioskController extends AbstractPage {
        protected init(): void {
            this.$scope.go = () => ApiController.instance.kiosk.request(this.$scope.pin, user => {
                this.$scope.$apply(() => {
                    this.$scope.confirm = true;
                    this.$scope.user = user;
                    console.log(user.picture);
                });
            });

        }
    }
}


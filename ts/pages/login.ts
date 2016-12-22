/// <reference path="../page.ts" />
/// <reference path="../navigation.ts" />

namespace org.usd232.robotics.management.pages {
    export class LoginController extends AbstractPage {
        protected init(): void {
            this.$scope.create = () => HistoryController.load("/create");
        }
    }
}

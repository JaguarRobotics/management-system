/// <reference path="../page.ts" />
/// <reference path="../navigation.ts" />
/// <reference path="../apis.ts" />
/// <reference path="login.ts" />

namespace org.usd232.robotics.management.pages {
    import ApiController = org.usd232.robotics.management.apis.ApiController;
    import LoginRequest = org.usd232.robotics.management.apis.LoginRequest;

    export class KioskController extends AbstractPage {
        private signIn(pin: number, verify: boolean): void {
            ApiController.instance.kiosk.request(pin, user => this.$scope.$apply(() => {
                this.$scope.user = user;
                this.$scope.confirm = user != null;
                if ( this.$scope.confirm ) {
                    if ( !verify ) {
                        this.$scope.me();
                    }
                } else {
                    Materialize.toast("Invalid pin number", 4000);
                }
            }));
        }

        protected init(): void {
            this.$scope.go = () => this.signIn(this.$scope.pin, true);
            this.$scope.notme = () => {
                this.$scope.confirm = false;
                this.$scope.pin = '';
            };
            this.$scope.me = () => {
                if ( this.$scope.user.unexcused > 10 ) {
                    ($("#kiosk-absence-error") as any).modal("open");
                } else if ( this.$scope.user.unexcused > 5 ) {
                    ($("#kiosk-absence-warning") as any).modal("open");
                } else {
                    this.$scope.finish();
                }
                this.$scope.confirm = false;
                this.$scope.pin = '';
            };
            this.$scope.finish = () => {
                ApiController.instance.kioskSignIn.request(this.$scope.user.id, response => { 
                    if (response.success) {
                        Materialize.toast(this.$scope.user.name + " has been signed in!", 4000);
                    } else {
                        Materialize.toast("There was an error in signing in your account", 4000);
                    }
                });
            };
        }

        protected open(): void {
            let decoder = ($(".kiosk-qr-video") as any).WebCodeCamJQuery({
                "DecodeQRCodeRate": 5,
                "DecodeBarCodeRate": null,
                "successTimeout": 500,
                "codeRepetition": true,
                "tryVertical": false,
                "frameRate": 15,
                "width": 640,
                "height": 480,
                "constraints": {
                    "video": {
                        "facingMode": "user"
                    }
                },
                "flipVertical": false,
                "flipHorizontal": false,
                "zoom": -1,
                "beep": "audio/beep.mp3",
                "decoderWorker": "js/DecoderWorker.js",
                "brightness": 0,
                "autoBrightnessValue": false,
                "grayScale": false,
                "contrast": 0,
                "threshold": 0,
                "sharpness": [],
                "resultFunction": result => this.signIn(parseInt(result.code), false),
                "cameraSuccess": () => {},
                "canPlayFunction": () => {},
                "getDevicesError": error => Materialize.toast(error, 4000),
                "getUserMediaError": error => Materialize.toast(error, 4000),
                "cameraError": error => Materialize.toast(error, 4000)
            }).data().plugin_WebCodeCamJQuery;
            decoder.init();
            decoder.play();
            if ( document.body.requestFullscreen ) {
                document.body.requestFullscreen();
            } else if ( document.body.webkitRequestFullscreen ) {
                document.body.webkitRequestFullscreen();
            } else if ( document.body.webkitRequestFullScreen ) {
                document.body.webkitRequestFullScreen();
            } else if ( (document.body as any).mozRequestFullScreen ) {
                (document.body as any).mozRequestFullScreen();
            }
        }
    }
}

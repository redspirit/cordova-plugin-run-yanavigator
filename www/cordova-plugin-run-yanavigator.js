var exec = require('cordova/exec');

exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "cordova-plugin-run-yanavigator", "coolMethod", [arg0]);
};

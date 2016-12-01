var exec = require('cordova/exec');

exports.launch = function (arg0, success, error) {
    exec(success, error, "YaNavigator", "launch", [arg0]);
};

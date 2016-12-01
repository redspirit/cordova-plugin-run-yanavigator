var exec = require('cordova/exec');

exports.launch = function (p1,p2,p3,p4, success, error) {
    exec(success, error, "YaNavigator", "launch", [p1,p2,p3,p4]);
};

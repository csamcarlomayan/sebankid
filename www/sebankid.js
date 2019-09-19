var exec = require('cordova/exec');

exports.startAuthCall = function (arg0, success, error) {
    exec(success, error, 'sebankid', 'startAuthCall', [arg0]);
};

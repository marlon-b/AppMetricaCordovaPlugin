#import <Foundation/Foundation.h>
#import <Cordova/CDVPlugin.h>
#import "YandexMobileMetrica.h"

@interface AppMetricaPlugin : CDVPlugin <UIApplicationDelegate>
- (void)activate:(CDVInvokedUrlCommand*)command;
@end
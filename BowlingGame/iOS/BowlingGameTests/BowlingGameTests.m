#import "Kiwi.h"
#import "BGKGame.h"

SPEC_BEGIN(GameSpec)

describe(@"Game", ^{
    
    __block BGKGame *g;
    
    void (^rollMany)(NSInteger, NSInteger) = ^(NSInteger nRolls, NSInteger nPins) {
        for (int i = 0; i < nRolls; i++) {
            [g rollAndKnockOverPins:nPins];
        }
    };
    
    void (^rollSpare)() = ^{
        [g rollAndKnockOverPins:5];
        [g rollAndKnockOverPins:5];
    };
    
    void (^rollStrike)() = ^{
        [g rollAndKnockOverPins:10];
    };
    
    beforeEach(^{
        g = [[BGKGame alloc] init];
    });
    
    it(@"rolls and hits no pins", ^{
        rollMany(20, 0);
        [[theValue([g score]) should] equal:theValue(0)];
    });
    
    it(@"rolls all 1s", ^{
        rollMany(20, 1);
        [[theValue([g score]) should] equal:theValue(20)];
    });
    
    it(@"rolls one spare", ^{
        rollSpare();
        [g rollAndKnockOverPins:3];
        [ g rollAndKnockOverPins:1];
        rollMany(16, 0);
        [[theValue([g score]) should] equal:theValue(17)];
    });
    
    it(@"rolls one strike", ^{
        rollStrike();
        [g rollAndKnockOverPins:3];
        [g rollAndKnockOverPins:4];
        rollMany(16, 0);
        [[theValue([g score]) should] equal:theValue(24)];
    });
    
    it(@"rolls perfect game", ^{
        rollMany(12, 10);
        [[theValue([g score]) should] equal:theValue(300)];
    });
    
});

SPEC_END
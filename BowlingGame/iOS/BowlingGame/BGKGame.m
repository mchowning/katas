//
//  BGKGame.m
//  BowlingGame
//
//  Created by Matt Chowning on 3/25/14.
//  Copyright (c) 2014 Matt Chowning. All rights reserved.
//

#import "BGKGame.h"

@interface BGKGame()

@property (nonatomic) NSMutableArray *rolls;
@property (nonatomic) NSInteger currentRoll;

@end

@implementation BGKGame

static NSInteger const NUMBER_OF_POSSIBLE_FRAMES = 10;
static NSInteger const NUMBER_OF_POSSIBLE_ROLLS = 1 + (NUMBER_OF_POSSIBLE_FRAMES * 2);

- (void)rollAndKnockOverPins:(NSInteger)numberOfPins {
    self.rolls[self.currentRoll++] = @(numberOfPins);
}

- (NSInteger)score {
    NSInteger result = 0;
    NSInteger rollIndex = 0;
    for (NSInteger frame = 0; frame < NUMBER_OF_POSSIBLE_FRAMES; frame++) {
        if ([self isStrike:rollIndex]) {
            result += 10 + [self strikeBonus:rollIndex];
            rollIndex++;
        } else if ([self isSpare:frame]) {
            result += 10 + [self spareBonus:rollIndex];
            rollIndex += 2;
        } else {
            NSInteger frameScore = [self.rolls[rollIndex] integerValue] + [self.rolls[rollIndex+1] integerValue];
            result += frameScore;
            rollIndex += 2;
        }
    }
    return result;
}

- (BOOL) isStrike:(NSInteger)rollIndex {
    return [self.rolls[rollIndex] integerValue] == 10;
}

- (BOOL)isSpare:(NSInteger)frame {
    NSInteger rollIndex = frame * 2;
    NSInteger firstBallScore = [self.rolls[rollIndex] integerValue];
    NSInteger secondBallScore = [self.rolls[rollIndex+1] integerValue];
    NSInteger frameScore = firstBallScore + secondBallScore;
    return frameScore == 10;
}

- (NSInteger)spareBonus:(NSInteger)rollIndex {
    return [self.rolls[2 + rollIndex] integerValue];
}

- (NSInteger)strikeBonus:(NSInteger)rollIndex {
    NSInteger nextBallScore = [self.rolls[1 + rollIndex] integerValue];
    NSInteger secondBallScore = [self.rolls[2 + rollIndex] integerValue];
    return nextBallScore + secondBallScore;
}

#pragma mark - Setter and Getter methods

- (NSMutableArray *)rolls {
    if (!_rolls) {
        _rolls = [[NSMutableArray alloc] init];
        for (int i = 0; i < NUMBER_OF_POSSIBLE_ROLLS; i++) {
            [_rolls addObject:[NSNumber numberWithInt:0]];
        }
    }
    return _rolls;
}

#pragma mark - Lifecycle methods

- (id)init {
    self = [super self];
    if (self) {
        self.currentRoll = 0;
    }
    return self;
}

@end

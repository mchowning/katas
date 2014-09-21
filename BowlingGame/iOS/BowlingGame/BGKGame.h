//
//  BGKGame.h
//  BowlingGame
//
//  Created by Matt Chowning on 3/25/14.
//  Copyright (c) 2014 Matt Chowning. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface BGKGame : NSObject

- (void)rollAndKnockOverPins:(NSInteger)numberOfPins;
- (NSInteger)score;


@end

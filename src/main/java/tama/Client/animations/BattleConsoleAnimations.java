/* (C) TAMA Studios 2025 */
package tama.Client.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class BattleConsoleAnimations {
    public static final AnimationDefinition FLIGHT = AnimationDefinition.Builder.withLength(32.0F)
            .looping()
            .addAnimation(
                    "DimensionCube",
                    new AnimationChannel(
                            AnimationChannel.Targets.ROTATION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(
                                    32.0F,
                                    KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation(
                    "DimensionCube",
                    new AnimationChannel(
                            AnimationChannel.Targets.POSITION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    2.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    4.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    6.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    8.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    10.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    12.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    14.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    16.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    18.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    20.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    22.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    24.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    26.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    28.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    30.0F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    32.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation(
                    "Rotor",
                    new AnimationChannel(
                            AnimationChannel.Targets.ROTATION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(
                                    32.0F,
                                    KeyframeAnimations.degreeVec(0.0F, 1440.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation(
                    "Rotor",
                    new AnimationChannel(
                            AnimationChannel.Targets.POSITION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    4.0F,
                                    KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    8.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    12.0F,
                                    KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    16.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    20.0F,
                                    KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    24.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    28.0F,
                                    KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    32.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .build();

    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(64.375F)
            .looping()
            .addAnimation(
                    "DimensionCube",
                    new AnimationChannel(
                            AnimationChannel.Targets.ROTATION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(
                                    64.375F,
                                    KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation(
                    "DimensionCube",
                    new AnimationChannel(
                            AnimationChannel.Targets.POSITION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    4.0833F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    8.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    12.0833F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    16.0833F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    20.1667F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    24.1667F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    28.25F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    32.1667F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    36.25F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    40.25F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    44.25F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    48.2083F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    52.2917F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    56.375F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    60.375F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    64.375F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation(
                    "EnergyCrystal",
                    new AnimationChannel(
                            AnimationChannel.Targets.ROTATION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(
                                    64.375F,
                                    KeyframeAnimations.degreeVec(0.0F, -360.0F, 0.0F),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation(
                    "EnergyCrystal",
                    new AnimationChannel(
                            AnimationChannel.Targets.POSITION,
                            new Keyframe(
                                    0.0F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    8.5417F,
                                    KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    17.0417F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    25.6667F,
                                    KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    34.0833F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    42.625F,
                                    KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    50.9583F,
                                    KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    59.6667F,
                                    KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(
                                    64.375F,
                                    KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .build();
}

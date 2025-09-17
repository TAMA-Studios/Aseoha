/* (C) TAMA Studios 2025 */
package tama.Client.Models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.tardis.mod.client.models.BaseTileHierarchicalModel;
import net.tardis.mod.client.models.IAnimatableTileModel;
import org.jetbrains.annotations.NotNull;
import tama.TileEntities.WhirlygigTile;
import tama.aseoha;

public class WhirlygigModel<T extends WhirlygigTile> extends BaseTileHierarchicalModel<WhirlygigTile>
        implements IAnimatableTileModel<WhirlygigTile> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation(aseoha.MODID, "whirlygigmodel"), "main");
    private final ModelPart first_rotor;
    private final ModelPart bone627;
    private final ModelPart bone628;
    private final ModelPart bone230;
    private final ModelPart bone231;
    private final ModelPart bone232;
    private final ModelPart bone240;
    private final ModelPart bone241;
    private final ModelPart bone242;
    private final ModelPart bone243;
    private final ModelPart bone244;
    private final ModelPart bone245;
    private final ModelPart bone246;
    private final ModelPart bone611;
    private final ModelPart glow_first_rotor12;
    private final ModelPart bone612;
    private final ModelPart glow_first_rotor11;
    private final ModelPart bone191;
    private final ModelPart glow_first_rotor10;
    private final ModelPart bone193;
    private final ModelPart glow_first_rotor9;
    private final ModelPart bone195;
    private final ModelPart glow_first_rotor8;
    private final ModelPart bone213;
    private final ModelPart glow_first_rotor7;
    private final ModelPart bone214;
    private final ModelPart glow_first_rotor6;
    private final ModelPart bone216;
    private final ModelPart glow_first_rotor5;
    private final ModelPart bone217;
    private final ModelPart glow_first_rotor4;
    private final ModelPart bone218;
    private final ModelPart glow_first_rotor3;
    private final ModelPart bone226;
    private final ModelPart glow_first_rotor2;
    private final ModelPart bone229;
    private final ModelPart glow_first_rotor;
    private final ModelPart second_rotor;
    private final ModelPart bone247;
    private final ModelPart bone248;
    private final ModelPart bone249;
    private final ModelPart bone250;
    private final ModelPart bone251;
    private final ModelPart bone252;
    private final ModelPart bone253;
    private final ModelPart bone254;
    private final ModelPart bone255;
    private final ModelPart bone256;
    private final ModelPart bone257;
    private final ModelPart bone258;
    private final ModelPart bone259;
    private final ModelPart glow_second_rotor12;
    private final ModelPart bone260;
    private final ModelPart glow_second_rotor11;
    private final ModelPart bone261;
    private final ModelPart glow_second_rotor10;
    private final ModelPart bone262;
    private final ModelPart glow_second_rotor9;
    private final ModelPart bone263;
    private final ModelPart glow_second_rotor8;
    private final ModelPart bone264;
    private final ModelPart glow_second_rotor7;
    private final ModelPart bone265;
    private final ModelPart glow_second_rotor6;
    private final ModelPart bone266;
    private final ModelPart glow_second_rotor5;
    private final ModelPart bone267;
    private final ModelPart glow_second_rotor4;
    private final ModelPart bone268;
    private final ModelPart glow_second_rotor3;
    private final ModelPart bone269;
    private final ModelPart glow_second_rotor2;
    private final ModelPart bone270;
    private final ModelPart glow_second_rotor;
    private final ModelPart third_rotor;
    private final ModelPart bone271;
    private final ModelPart bone272;
    private final ModelPart bone273;
    private final ModelPart bone274;
    private final ModelPart bone275;
    private final ModelPart bone276;
    private final ModelPart bone277;
    private final ModelPart bone278;
    private final ModelPart bone279;
    private final ModelPart bone280;
    private final ModelPart bone281;
    private final ModelPart bone282;
    private final ModelPart bone283;
    private final ModelPart glow_third_rotor12;
    private final ModelPart bone284;
    private final ModelPart glow_third_rotor11;
    private final ModelPart bone285;
    private final ModelPart glow_third_rotor10;
    private final ModelPart bone286;
    private final ModelPart glow_third_rotor9;
    private final ModelPart bone287;
    private final ModelPart glow_third_rotor8;
    private final ModelPart bone288;
    private final ModelPart glow_third_rotor7;
    private final ModelPart bone289;
    private final ModelPart glow_third_rotor6;
    private final ModelPart bone290;
    private final ModelPart glow_third_rotor5;
    private final ModelPart bone291;
    private final ModelPart glow_third_rotor4;
    private final ModelPart bone292;
    private final ModelPart glow_third_rotor3;
    private final ModelPart bone293;
    private final ModelPart glow_third_rotor2;
    private final ModelPart bone294;
    private final ModelPart glow_third_rotor;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart bone6;
    private final ModelPart bone7;
    private final ModelPart bone8;
    private final ModelPart bone9;
    private final ModelPart bone10;
    private final ModelPart bone11;
    private final ModelPart bone12;
    private final ModelPart bone13;
    private final ModelPart bottom;
    private final ModelPart bone175;
    private final ModelPart bone579;
    private final ModelPart bone580;
    private final ModelPart bone581;
    private final ModelPart bone582;
    private final ModelPart bone315;
    private final ModelPart bone316;
    private final ModelPart bone317;
    private final ModelPart bone318;
    private final ModelPart bone319;
    private final ModelPart bone320;
    private final ModelPart bone321;
    private final ModelPart bone322;
    private final ModelPart bone323;
    private final ModelPart bone324;
    private final ModelPart bone325;
    private final ModelPart bone326;
    private final ModelPart bone327;
    private final ModelPart bone328;
    private final ModelPart bone329;
    private final ModelPart bone330;
    private final ModelPart bone331;
    private final ModelPart bone332;
    private final ModelPart bone333;
    private final ModelPart bone334;
    private final ModelPart bone532;
    private final ModelPart bone553;
    private final ModelPart bone534;
    private final ModelPart bone549;
    private final ModelPart bone295;
    private final ModelPart bone296;
    private final ModelPart bone297;
    private final ModelPart bone298;
    private final ModelPart bone299;
    private final ModelPart bone300;
    private final ModelPart bone301;
    private final ModelPart bone302;
    private final ModelPart bone303;
    private final ModelPart bone304;
    private final ModelPart bone305;
    private final ModelPart bone306;
    private final ModelPart bone307;
    private final ModelPart bone308;
    private final ModelPart bone309;
    private final ModelPart bone310;
    private final ModelPart bone311;
    private final ModelPart bone312;
    private final ModelPart bone313;
    private final ModelPart bone314;
    private final ModelPart bone335;
    private final ModelPart bone336;
    private final ModelPart bone337;
    private final ModelPart bone338;
    private final ModelPart bone339;
    private final ModelPart bone340;
    private final ModelPart bone341;
    private final ModelPart bone342;
    private final ModelPart bone343;
    private final ModelPart bone344;
    private final ModelPart bone345;
    private final ModelPart bone346;
    private final ModelPart bone347;

    public WhirlygigModel(ModelPart root) {
        super(root);
        this.first_rotor = root.getChild("first_rotor");
        this.bone627 = this.first_rotor.getChild("bone627");
        this.bone628 = this.bone627.getChild("bone628");
        this.bone230 = this.bone628.getChild("bone230");
        this.bone231 = this.bone230.getChild("bone231");
        this.bone232 = this.bone231.getChild("bone232");
        this.bone240 = this.bone232.getChild("bone240");
        this.bone241 = this.bone240.getChild("bone241");
        this.bone242 = this.bone241.getChild("bone242");
        this.bone243 = this.bone242.getChild("bone243");
        this.bone244 = this.bone243.getChild("bone244");
        this.bone245 = this.bone244.getChild("bone245");
        this.bone246 = this.bone245.getChild("bone246");
        this.bone611 = this.first_rotor.getChild("bone611");
        this.glow_first_rotor12 = this.bone611.getChild("glow_first_rotor12");
        this.bone612 = this.bone611.getChild("bone612");
        this.glow_first_rotor11 = this.bone612.getChild("glow_first_rotor11");
        this.bone191 = this.bone612.getChild("bone191");
        this.glow_first_rotor10 = this.bone191.getChild("glow_first_rotor10");
        this.bone193 = this.bone191.getChild("bone193");
        this.glow_first_rotor9 = this.bone193.getChild("glow_first_rotor9");
        this.bone195 = this.bone193.getChild("bone195");
        this.glow_first_rotor8 = this.bone195.getChild("glow_first_rotor8");
        this.bone213 = this.bone195.getChild("bone213");
        this.glow_first_rotor7 = this.bone213.getChild("glow_first_rotor7");
        this.bone214 = this.bone213.getChild("bone214");
        this.glow_first_rotor6 = this.bone214.getChild("glow_first_rotor6");
        this.bone216 = this.bone214.getChild("bone216");
        this.glow_first_rotor5 = this.bone216.getChild("glow_first_rotor5");
        this.bone217 = this.bone216.getChild("bone217");
        this.glow_first_rotor4 = this.bone217.getChild("glow_first_rotor4");
        this.bone218 = this.bone217.getChild("bone218");
        this.glow_first_rotor3 = this.bone218.getChild("glow_first_rotor3");
        this.bone226 = this.bone218.getChild("bone226");
        this.glow_first_rotor2 = this.bone226.getChild("glow_first_rotor2");
        this.bone229 = this.bone226.getChild("bone229");
        this.glow_first_rotor = this.bone229.getChild("glow_first_rotor");
        this.second_rotor = root.getChild("second_rotor");
        this.bone247 = this.second_rotor.getChild("bone247");
        this.bone248 = this.bone247.getChild("bone248");
        this.bone249 = this.bone248.getChild("bone249");
        this.bone250 = this.bone249.getChild("bone250");
        this.bone251 = this.bone250.getChild("bone251");
        this.bone252 = this.bone251.getChild("bone252");
        this.bone253 = this.bone252.getChild("bone253");
        this.bone254 = this.bone253.getChild("bone254");
        this.bone255 = this.bone254.getChild("bone255");
        this.bone256 = this.bone255.getChild("bone256");
        this.bone257 = this.bone256.getChild("bone257");
        this.bone258 = this.bone257.getChild("bone258");
        this.bone259 = this.second_rotor.getChild("bone259");
        this.glow_second_rotor12 = this.bone259.getChild("glow_second_rotor12");
        this.bone260 = this.bone259.getChild("bone260");
        this.glow_second_rotor11 = this.bone260.getChild("glow_second_rotor11");
        this.bone261 = this.bone260.getChild("bone261");
        this.glow_second_rotor10 = this.bone261.getChild("glow_second_rotor10");
        this.bone262 = this.bone261.getChild("bone262");
        this.glow_second_rotor9 = this.bone262.getChild("glow_second_rotor9");
        this.bone263 = this.bone262.getChild("bone263");
        this.glow_second_rotor8 = this.bone263.getChild("glow_second_rotor8");
        this.bone264 = this.bone263.getChild("bone264");
        this.glow_second_rotor7 = this.bone264.getChild("glow_second_rotor7");
        this.bone265 = this.bone264.getChild("bone265");
        this.glow_second_rotor6 = this.bone265.getChild("glow_second_rotor6");
        this.bone266 = this.bone265.getChild("bone266");
        this.glow_second_rotor5 = this.bone266.getChild("glow_second_rotor5");
        this.bone267 = this.bone266.getChild("bone267");
        this.glow_second_rotor4 = this.bone267.getChild("glow_second_rotor4");
        this.bone268 = this.bone267.getChild("bone268");
        this.glow_second_rotor3 = this.bone268.getChild("glow_second_rotor3");
        this.bone269 = this.bone268.getChild("bone269");
        this.glow_second_rotor2 = this.bone269.getChild("glow_second_rotor2");
        this.bone270 = this.bone269.getChild("bone270");
        this.glow_second_rotor = this.bone270.getChild("glow_second_rotor");
        this.third_rotor = root.getChild("third_rotor");
        this.bone271 = this.third_rotor.getChild("bone271");
        this.bone272 = this.bone271.getChild("bone272");
        this.bone273 = this.bone272.getChild("bone273");
        this.bone274 = this.bone273.getChild("bone274");
        this.bone275 = this.bone274.getChild("bone275");
        this.bone276 = this.bone275.getChild("bone276");
        this.bone277 = this.bone276.getChild("bone277");
        this.bone278 = this.bone277.getChild("bone278");
        this.bone279 = this.bone278.getChild("bone279");
        this.bone280 = this.bone279.getChild("bone280");
        this.bone281 = this.bone280.getChild("bone281");
        this.bone282 = this.bone281.getChild("bone282");
        this.bone283 = this.third_rotor.getChild("bone283");
        this.glow_third_rotor12 = this.bone283.getChild("glow_third_rotor12");
        this.bone284 = this.bone283.getChild("bone284");
        this.glow_third_rotor11 = this.bone284.getChild("glow_third_rotor11");
        this.bone285 = this.bone284.getChild("bone285");
        this.glow_third_rotor10 = this.bone285.getChild("glow_third_rotor10");
        this.bone286 = this.bone285.getChild("bone286");
        this.glow_third_rotor9 = this.bone286.getChild("glow_third_rotor9");
        this.bone287 = this.bone286.getChild("bone287");
        this.glow_third_rotor8 = this.bone287.getChild("glow_third_rotor8");
        this.bone288 = this.bone287.getChild("bone288");
        this.glow_third_rotor7 = this.bone288.getChild("glow_third_rotor7");
        this.bone289 = this.bone288.getChild("bone289");
        this.glow_third_rotor6 = this.bone289.getChild("glow_third_rotor6");
        this.bone290 = this.bone289.getChild("bone290");
        this.glow_third_rotor5 = this.bone290.getChild("glow_third_rotor5");
        this.bone291 = this.bone290.getChild("bone291");
        this.glow_third_rotor4 = this.bone291.getChild("glow_third_rotor4");
        this.bone292 = this.bone291.getChild("bone292");
        this.glow_third_rotor3 = this.bone292.getChild("glow_third_rotor3");
        this.bone293 = this.bone292.getChild("bone293");
        this.glow_third_rotor2 = this.bone293.getChild("glow_third_rotor2");
        this.bone294 = this.bone293.getChild("bone294");
        this.glow_third_rotor = this.bone294.getChild("glow_third_rotor");
        this.bone2 = this.third_rotor.getChild("bone2");
        this.bone3 = this.bone2.getChild("bone3");
        this.bone4 = this.bone3.getChild("bone4");
        this.bone5 = this.bone4.getChild("bone5");
        this.bone6 = this.bone5.getChild("bone6");
        this.bone7 = this.bone6.getChild("bone7");
        this.bone8 = this.bone7.getChild("bone8");
        this.bone9 = this.bone8.getChild("bone9");
        this.bone10 = this.bone9.getChild("bone10");
        this.bone11 = this.bone10.getChild("bone11");
        this.bone12 = this.bone11.getChild("bone12");
        this.bone13 = this.bone12.getChild("bone13");
        this.bottom = root.getChild("bottom");
        this.bone175 = this.bottom.getChild("bone175");
        this.bone579 = this.bone175.getChild("bone579");
        this.bone580 = this.bone579.getChild("bone580");
        this.bone581 = this.bone579.getChild("bone581");
        this.bone582 = this.bone581.getChild("bone582");
        this.bone315 = this.bone581.getChild("bone315");
        this.bone316 = this.bone315.getChild("bone316");
        this.bone317 = this.bone315.getChild("bone317");
        this.bone318 = this.bone317.getChild("bone318");
        this.bone319 = this.bone317.getChild("bone319");
        this.bone320 = this.bone319.getChild("bone320");
        this.bone321 = this.bone319.getChild("bone321");
        this.bone322 = this.bone321.getChild("bone322");
        this.bone323 = this.bone321.getChild("bone323");
        this.bone324 = this.bone323.getChild("bone324");
        this.bone325 = this.bone323.getChild("bone325");
        this.bone326 = this.bone325.getChild("bone326");
        this.bone327 = this.bone325.getChild("bone327");
        this.bone328 = this.bone327.getChild("bone328");
        this.bone329 = this.bone327.getChild("bone329");
        this.bone330 = this.bone329.getChild("bone330");
        this.bone331 = this.bone329.getChild("bone331");
        this.bone332 = this.bone331.getChild("bone332");
        this.bone333 = this.bone331.getChild("bone333");
        this.bone334 = this.bone333.getChild("bone334");
        this.bone532 = this.bone175.getChild("bone532");
        this.bone553 = this.bone532.getChild("bone553");
        this.bone534 = this.bone532.getChild("bone534");
        this.bone549 = this.bone534.getChild("bone549");
        this.bone295 = this.bone534.getChild("bone295");
        this.bone296 = this.bone295.getChild("bone296");
        this.bone297 = this.bone295.getChild("bone297");
        this.bone298 = this.bone297.getChild("bone298");
        this.bone299 = this.bone297.getChild("bone299");
        this.bone300 = this.bone299.getChild("bone300");
        this.bone301 = this.bone299.getChild("bone301");
        this.bone302 = this.bone301.getChild("bone302");
        this.bone303 = this.bone301.getChild("bone303");
        this.bone304 = this.bone303.getChild("bone304");
        this.bone305 = this.bone303.getChild("bone305");
        this.bone306 = this.bone305.getChild("bone306");
        this.bone307 = this.bone305.getChild("bone307");
        this.bone308 = this.bone307.getChild("bone308");
        this.bone309 = this.bone307.getChild("bone309");
        this.bone310 = this.bone309.getChild("bone310");
        this.bone311 = this.bone309.getChild("bone311");
        this.bone312 = this.bone311.getChild("bone312");
        this.bone313 = this.bone311.getChild("bone313");
        this.bone314 = this.bone313.getChild("bone314");
        this.bone335 = this.bottom.getChild("bone335");
        this.bone336 = this.bone335.getChild("bone336");
        this.bone337 = this.bone336.getChild("bone337");
        this.bone338 = this.bone337.getChild("bone338");
        this.bone339 = this.bone338.getChild("bone339");
        this.bone340 = this.bone339.getChild("bone340");
        this.bone341 = this.bone340.getChild("bone341");
        this.bone342 = this.bone335.getChild("bone342");
        this.bone343 = this.bone342.getChild("bone343");
        this.bone344 = this.bone343.getChild("bone344");
        this.bone345 = this.bone344.getChild("bone345");
        this.bone346 = this.bone345.getChild("bone346");
        this.bone347 = this.bone346.getChild("bone347");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition first_rotor = partdefinition.addOrReplaceChild(
                "first_rotor",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 14.375F, 0.0F, 0.0F, -0.2182F, 0.0F));

        PartDefinition bone627 = first_rotor.addOrReplaceChild(
                "bone627",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 9.25F, 0.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition bone628 = bone627.addOrReplaceChild(
                "bone628",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone230 = bone628.addOrReplaceChild(
                "bone230",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone231 = bone230.addOrReplaceChild(
                "bone231",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone232 = bone231.addOrReplaceChild(
                "bone232",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone240 = bone232.addOrReplaceChild(
                "bone240",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone241 = bone240.addOrReplaceChild(
                "bone241",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone242 = bone241.addOrReplaceChild(
                "bone242",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone243 = bone242.addOrReplaceChild(
                "bone243",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone244 = bone243.addOrReplaceChild(
                "bone244",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone245 = bone244.addOrReplaceChild(
                "bone245",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone246 = bone245.addOrReplaceChild(
                "bone246",
                CubeListBuilder.create()
                        .texOffs(48, 49)
                        .addBox(-1.5F, -14.775F, 11.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone611 = first_rotor.addOrReplaceChild(
                "bone611",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 9.25F, 0.0F));

        PartDefinition glow_first_rotor12 = bone611.addOrReplaceChild(
                "glow_first_rotor12",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone612 = bone611.addOrReplaceChild(
                "bone612",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor11 = bone612.addOrReplaceChild(
                "glow_first_rotor11",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone191 = bone612.addOrReplaceChild(
                "bone191",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor10 = bone191.addOrReplaceChild(
                "glow_first_rotor10",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone193 = bone191.addOrReplaceChild(
                "bone193",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor9 = bone193.addOrReplaceChild(
                "glow_first_rotor9",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone195 = bone193.addOrReplaceChild(
                "bone195",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor8 = bone195.addOrReplaceChild(
                "glow_first_rotor8",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone213 = bone195.addOrReplaceChild(
                "bone213",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor7 = bone213.addOrReplaceChild(
                "glow_first_rotor7",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone214 = bone213.addOrReplaceChild(
                "bone214",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor6 = bone214.addOrReplaceChild(
                "glow_first_rotor6",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone216 = bone214.addOrReplaceChild(
                "bone216",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor5 = bone216.addOrReplaceChild(
                "glow_first_rotor5",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone217 = bone216.addOrReplaceChild(
                "bone217",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor4 = bone217.addOrReplaceChild(
                "glow_first_rotor4",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone218 = bone217.addOrReplaceChild(
                "bone218",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor3 = bone218.addOrReplaceChild(
                "glow_first_rotor3",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone226 = bone218.addOrReplaceChild(
                "bone226",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor2 = bone226.addOrReplaceChild(
                "glow_first_rotor2",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition bone229 = bone226.addOrReplaceChild(
                "bone229",
                CubeListBuilder.create()
                        .texOffs(46, 0)
                        .addBox(-4.5F, -14.525F, 11.7F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_first_rotor = bone229.addOrReplaceChild(
                "glow_first_rotor",
                CubeListBuilder.create()
                        .texOffs(55, 1)
                        .addBox(-6.5675F, -2.475F, 0.1505F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.0675F, -4.0F, 13.5495F));

        PartDefinition second_rotor = partdefinition.addOrReplaceChild(
                "second_rotor",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 5.875F, 0.0F, 0.0F, -0.2182F, 0.0F));

        PartDefinition bone247 = second_rotor.addOrReplaceChild(
                "bone247",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 9.25F, 0.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition bone248 = bone247.addOrReplaceChild(
                "bone248",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone249 = bone248.addOrReplaceChild(
                "bone249",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone250 = bone249.addOrReplaceChild(
                "bone250",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone251 = bone250.addOrReplaceChild(
                "bone251",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone252 = bone251.addOrReplaceChild(
                "bone252",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone253 = bone252.addOrReplaceChild(
                "bone253",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone254 = bone253.addOrReplaceChild(
                "bone254",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone255 = bone254.addOrReplaceChild(
                "bone255",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone256 = bone255.addOrReplaceChild(
                "bone256",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone257 = bone256.addOrReplaceChild(
                "bone257",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone258 = bone257.addOrReplaceChild(
                "bone258",
                CubeListBuilder.create()
                        .texOffs(28, 49)
                        .addBox(-1.5F, -14.775F, 16.95F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone259 = second_rotor.addOrReplaceChild(
                "bone259",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 9.25F, 0.0F));

        PartDefinition glow_second_rotor12 = bone259.addOrReplaceChild(
                "glow_second_rotor12",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone260 = bone259.addOrReplaceChild(
                "bone260",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor11 = bone260.addOrReplaceChild(
                "glow_second_rotor11",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone261 = bone260.addOrReplaceChild(
                "bone261",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor10 = bone261.addOrReplaceChild(
                "glow_second_rotor10",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone262 = bone261.addOrReplaceChild(
                "bone262",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor9 = bone262.addOrReplaceChild(
                "glow_second_rotor9",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone263 = bone262.addOrReplaceChild(
                "bone263",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor8 = bone263.addOrReplaceChild(
                "glow_second_rotor8",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone264 = bone263.addOrReplaceChild(
                "bone264",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor7 = bone264.addOrReplaceChild(
                "glow_second_rotor7",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone265 = bone264.addOrReplaceChild(
                "bone265",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor6 = bone265.addOrReplaceChild(
                "glow_second_rotor6",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone266 = bone265.addOrReplaceChild(
                "bone266",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor5 = bone266.addOrReplaceChild(
                "glow_second_rotor5",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone267 = bone266.addOrReplaceChild(
                "bone267",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor4 = bone267.addOrReplaceChild(
                "glow_second_rotor4",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone268 = bone267.addOrReplaceChild(
                "bone268",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor3 = bone268.addOrReplaceChild(
                "glow_second_rotor3",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone269 = bone268.addOrReplaceChild(
                "bone269",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor2 = bone269.addOrReplaceChild(
                "glow_second_rotor2",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition bone270 = bone269.addOrReplaceChild(
                "bone270",
                CubeListBuilder.create()
                        .texOffs(34, 34)
                        .addBox(-5.5F, -14.525F, 16.7F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_second_rotor = bone270.addOrReplaceChild(
                "glow_second_rotor",
                CubeListBuilder.create()
                        .texOffs(42, 34)
                        .addBox(-3.5F, -3.0F, 6.675F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -3.5F, 12.0F));

        PartDefinition third_rotor = partdefinition.addOrReplaceChild(
                "third_rotor",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -2.625F, 0.0F, 0.0F, -0.2182F, 0.0F));

        PartDefinition bone271 = third_rotor.addOrReplaceChild(
                "bone271",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 9.25F, 0.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition bone272 = bone271.addOrReplaceChild(
                "bone272",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone273 = bone272.addOrReplaceChild(
                "bone273",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone274 = bone273.addOrReplaceChild(
                "bone274",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone275 = bone274.addOrReplaceChild(
                "bone275",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone276 = bone275.addOrReplaceChild(
                "bone276",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone277 = bone276.addOrReplaceChild(
                "bone277",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone278 = bone277.addOrReplaceChild(
                "bone278",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone279 = bone278.addOrReplaceChild(
                "bone279",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone280 = bone279.addOrReplaceChild(
                "bone280",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone281 = bone280.addOrReplaceChild(
                "bone281",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone282 = bone281.addOrReplaceChild(
                "bone282",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.5F, -14.775F, 22.2F, 3.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone283 = third_rotor.addOrReplaceChild(
                "bone283",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 9.25F, 0.0F));

        PartDefinition glow_third_rotor12 = bone283.addOrReplaceChild(
                "glow_third_rotor12",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone284 = bone283.addOrReplaceChild(
                "bone284",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor11 = bone284.addOrReplaceChild(
                "glow_third_rotor11",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone285 = bone284.addOrReplaceChild(
                "bone285",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor10 = bone285.addOrReplaceChild(
                "glow_third_rotor10",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone286 = bone285.addOrReplaceChild(
                "bone286",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor9 = bone286.addOrReplaceChild(
                "glow_third_rotor9",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone287 = bone286.addOrReplaceChild(
                "bone287",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor8 = bone287.addOrReplaceChild(
                "glow_third_rotor8",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone288 = bone287.addOrReplaceChild(
                "bone288",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor7 = bone288.addOrReplaceChild(
                "glow_third_rotor7",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone289 = bone288.addOrReplaceChild(
                "bone289",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor6 = bone289.addOrReplaceChild(
                "glow_third_rotor6",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone290 = bone289.addOrReplaceChild(
                "bone290",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor5 = bone290.addOrReplaceChild(
                "glow_third_rotor5",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone291 = bone290.addOrReplaceChild(
                "bone291",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor4 = bone291.addOrReplaceChild(
                "glow_third_rotor4",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone292 = bone291.addOrReplaceChild(
                "bone292",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor3 = bone292.addOrReplaceChild(
                "glow_third_rotor3",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone293 = bone292.addOrReplaceChild(
                "bone293",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor2 = bone293.addOrReplaceChild(
                "glow_third_rotor2",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone294 = bone293.addOrReplaceChild(
                "bone294",
                CubeListBuilder.create()
                        .texOffs(0, 23)
                        .addBox(-7.0F, -14.525F, 21.7F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition glow_third_rotor = bone294.addOrReplaceChild(
                "glow_third_rotor",
                CubeListBuilder.create()
                        .texOffs(10, 24)
                        .addBox(-8.9484F, -3.0F, -0.2891F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.9234F, -3.5F, 22.9891F));

        PartDefinition bone2 = third_rotor.addOrReplaceChild(
                "bone2",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 1.25F, 0.0F));

        PartDefinition bone3 = bone2.addOrReplaceChild(
                "bone3",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone4 = bone3.addOrReplaceChild(
                "bone4",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone5 = bone4.addOrReplaceChild(
                "bone5",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild(
                "bone6",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone7 = bone6.addOrReplaceChild(
                "bone7",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone8 = bone7.addOrReplaceChild(
                "bone8",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone9 = bone8.addOrReplaceChild(
                "bone9",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone10 = bone9.addOrReplaceChild(
                "bone10",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone11 = bone10.addOrReplaceChild(
                "bone11",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone12 = bone11.addOrReplaceChild(
                "bone12",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone13 = bone12.addOrReplaceChild(
                "bone13",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-6.0F, -6.525F, -0.25F, 12.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bottom = partdefinition.addOrReplaceChild(
                "bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 66.875F, 0.0F));

        PartDefinition bone175 =
                bottom.addOrReplaceChild("bone175", CubeListBuilder.create(), PartPose.offset(0.0F, 4.875F, 0.0F));

        PartDefinition bone579 = bone175.addOrReplaceChild(
                "bone579",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, -44.75F, 0.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition bone580 = bone579.addOrReplaceChild(
                "bone580",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone581 = bone579.addOrReplaceChild(
                "bone581",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone582 = bone581.addOrReplaceChild(
                "bone582",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone315 = bone581.addOrReplaceChild(
                "bone315",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone316 = bone315.addOrReplaceChild(
                "bone316",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone317 = bone315.addOrReplaceChild(
                "bone317",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone318 = bone317.addOrReplaceChild(
                "bone318",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone319 = bone317.addOrReplaceChild(
                "bone319",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone320 = bone319.addOrReplaceChild(
                "bone320",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone321 = bone319.addOrReplaceChild(
                "bone321",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone322 = bone321.addOrReplaceChild(
                "bone322",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone323 = bone321.addOrReplaceChild(
                "bone323",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone324 = bone323.addOrReplaceChild(
                "bone324",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone325 = bone323.addOrReplaceChild(
                "bone325",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone326 = bone325.addOrReplaceChild(
                "bone326",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone327 = bone325.addOrReplaceChild(
                "bone327",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone328 = bone327.addOrReplaceChild(
                "bone328",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone329 = bone327.addOrReplaceChild(
                "bone329",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone330 = bone329.addOrReplaceChild(
                "bone330",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone331 = bone329.addOrReplaceChild(
                "bone331",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone332 = bone331.addOrReplaceChild(
                "bone332",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone333 = bone331.addOrReplaceChild(
                "bone333",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone334 = bone333.addOrReplaceChild(
                "bone334",
                CubeListBuilder.create()
                        .texOffs(0, 49)
                        .addBox(-1.0F, -0.5F, -0.375F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone532 =
                bone175.addOrReplaceChild("bone532", CubeListBuilder.create(), PartPose.offset(0.0F, -44.75F, 0.0F));

        PartDefinition bone553 = bone532.addOrReplaceChild(
                "bone553",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone534 = bone532.addOrReplaceChild(
                "bone534",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone549 = bone534.addOrReplaceChild(
                "bone549",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone295 = bone534.addOrReplaceChild(
                "bone295",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone296 = bone295.addOrReplaceChild(
                "bone296",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone297 = bone295.addOrReplaceChild(
                "bone297",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone298 = bone297.addOrReplaceChild(
                "bone298",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone299 = bone297.addOrReplaceChild(
                "bone299",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone300 = bone299.addOrReplaceChild(
                "bone300",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone301 = bone299.addOrReplaceChild(
                "bone301",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone302 = bone301.addOrReplaceChild(
                "bone302",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone303 = bone301.addOrReplaceChild(
                "bone303",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone304 = bone303.addOrReplaceChild(
                "bone304",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone305 = bone303.addOrReplaceChild(
                "bone305",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone306 = bone305.addOrReplaceChild(
                "bone306",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone307 = bone305.addOrReplaceChild(
                "bone307",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone308 = bone307.addOrReplaceChild(
                "bone308",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone309 = bone307.addOrReplaceChild(
                "bone309",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone310 = bone309.addOrReplaceChild(
                "bone310",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone311 = bone309.addOrReplaceChild(
                "bone311",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone312 = bone311.addOrReplaceChild(
                "bone312",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone313 = bone311.addOrReplaceChild(
                "bone313",
                CubeListBuilder.create(),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone314 = bone313.addOrReplaceChild(
                "bone314",
                CubeListBuilder.create()
                        .texOffs(1, 38)
                        .addBox(-3.0F, -1.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.525F, 6.2F, 0.6109F, 0.0F, 0.0F));

        PartDefinition bone335 =
                bottom.addOrReplaceChild("bone335", CubeListBuilder.create(), PartPose.offset(0.0F, -19.5F, 0.0F));

        PartDefinition bone336 = bone335.addOrReplaceChild(
                "bone336",
                CubeListBuilder.create()
                        .texOffs(40, 23)
                        .addBox(-3.0F, -6.25F, -0.8F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -18.0F, 0.0F));

        PartDefinition bone337 = bone336.addOrReplaceChild(
                "bone337",
                CubeListBuilder.create()
                        .texOffs(40, 23)
                        .addBox(-3.0F, -6.25F, -0.8F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone338 = bone337.addOrReplaceChild(
                "bone338",
                CubeListBuilder.create()
                        .texOffs(40, 23)
                        .addBox(-3.0F, -6.25F, -0.8F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone339 = bone338.addOrReplaceChild(
                "bone339",
                CubeListBuilder.create()
                        .texOffs(40, 23)
                        .addBox(-3.0F, -6.25F, -0.8F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone340 = bone339.addOrReplaceChild(
                "bone340",
                CubeListBuilder.create()
                        .texOffs(40, 23)
                        .addBox(-3.0F, -6.25F, -0.8F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone341 = bone340.addOrReplaceChild(
                "bone341",
                CubeListBuilder.create()
                        .texOffs(40, 23)
                        .addBox(-3.0F, -6.25F, -0.8F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone342 = bone335.addOrReplaceChild(
                "bone342",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-0.5F, -6.25F, 5.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -18.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition bone343 = bone342.addOrReplaceChild(
                "bone343",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-0.5F, -6.25F, 5.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone344 = bone343.addOrReplaceChild(
                "bone344",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-0.5F, -6.25F, 5.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone345 = bone344.addOrReplaceChild(
                "bone345",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-0.5F, -6.25F, 5.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone346 = bone345.addOrReplaceChild(
                "bone346",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-0.5F, -6.25F, 5.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition bone347 = bone346.addOrReplaceChild(
                "bone347",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-0.5F, -6.25F, 5.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(
            @NotNull PoseStack poseStack,
            @NotNull VertexConsumer vertexConsumer,
            int packedLight,
            int packedOverlay,
            float red,
            float green,
            float blue,
            float alpha) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.43, 0.5);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        float scale = 1.2F;
        poseStack.scale(scale, scale, scale);

        first_rotor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        second_rotor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        third_rotor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    @Override
    public void setupAnimations(WhirlygigTile tile, float ageInTicks) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(tile.ANIM, WhirlygigAnimation.SPIN, ageInTicks);
    }

    public static class WhirlygigAnimation {
        public static final AnimationDefinition SPIN = AnimationDefinition.Builder.withLength(4.0F)
                .looping()
                .addAnimation(
                        "first_rotor",
                        new AnimationChannel(
                                AnimationChannel.Targets.ROTATION,
                                new Keyframe(
                                        0.0F,
                                        KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(
                                        4.0F,
                                        KeyframeAnimations.degreeVec(0.0F, 60.0F, 0.0F),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation(
                        "second_rotor",
                        new AnimationChannel(
                                AnimationChannel.Targets.ROTATION,
                                new Keyframe(
                                        0.0F,
                                        KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(
                                        4.0F,
                                        KeyframeAnimations.degreeVec(0.0F, -60.0F, 0.0F),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation(
                        "third_rotor",
                        new AnimationChannel(
                                AnimationChannel.Targets.ROTATION,
                                new Keyframe(
                                        0.0F,
                                        KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(
                                        4.0F,
                                        KeyframeAnimations.degreeVec(0.0F, 60.0F, 0.0F),
                                        AnimationChannel.Interpolations.LINEAR)))
                .build();
    }
}

package day5

const val DAY_5_TEST_INPUT = "seeds: 79 14 55 13\n" +
        "\n" +
        "seed-to-soil map:\n" +
        "50 98 2\n" +
        "52 50 48\n" +
        "\n" +
        "soil-to-fertilizer map:\n" +
        "0 15 37\n" +
        "37 52 2\n" +
        "39 0 15\n" +
        "\n" +
        "fertilizer-to-water map:\n" +
        "49 53 8\n" +
        "0 11 42\n" +
        "42 0 7\n" +
        "57 7 4\n" +
        "\n" +
        "water-to-light map:\n" +
        "88 18 7\n" +
        "18 25 70\n" +
        "\n" +
        "light-to-temperature map:\n" +
        "45 77 23\n" +
        "81 45 19\n" +
        "68 64 13\n" +
        "\n" +
        "temperature-to-humidity map:\n" +
        "0 69 1\n" +
        "1 0 69\n" +
        "\n" +
        "humidity-to-location map:\n" +
        "60 56 37\n" +
        "56 93 4"

const val DAY_5_INPUT =
    "seeds: 3121711159 166491471 3942191905 154855415 3423756552 210503354 2714499581 312077252 1371898531 165242002 752983293 93023991 3321707304 21275084 949929163 233055973 3626585 170407229 395618482 226312891\n" +
            "\n" +
            "seed-to-soil map:\n" +
            "522866878 679694818 556344137\n" +
            "1206934522 1236038955 57448427\n" +
            "2572695651 3529213882 270580892\n" +
            "1082547209 29063229 124387313\n" +
            "2080101996 2392534586 180161065\n" +
            "1079211015 153450542 3336194\n" +
            "2466695431 2286534366 106000220\n" +
            "1887791814 2094224184 192310182\n" +
            "2843276543 2572695651 956518231\n" +
            "2341707296 1887791814 124988135\n" +
            "1264382949 156786736 473875833\n" +
            "67220304 1331644457 455646574\n" +
            "3903217571 3799794774 267521683\n" +
            "2260263061 2012779949 81444235\n" +
            "1738258782 630662569 49032249\n" +
            "29063229 1293487382 38157075\n" +
            "3799794774 4067316457 103422797\n" +
            "\n" +
            "soil-to-fertilizer map:\n" +
            "69994133 1665188283 300635345\n" +
            "0 1965823628 36826481\n" +
            "2222587532 2553838094 476943506\n" +
            "2929387922 3030781600 856348250\n" +
            "4182440411 2441311209 112526885\n" +
            "36826481 2002650109 33167652\n" +
            "2044606970 4116986734 177980562\n" +
            "1815516279 549395220 220301482\n" +
            "1186435707 0 549395220\n" +
            "916609638 1315676862 269826069\n" +
            "3785736172 2044606970 396704239\n" +
            "2699531038 3887129850 229856884\n" +
            "1735830927 1585502931 79685352\n" +
            "370629478 769696702 545980160\n" +
            "\n" +
            "fertilizer-to-water map:\n" +
            "2485494684 3430237839 78539769\n" +
            "2045426403 2253341567 99573285\n" +
            "290571869 0 280695139\n" +
            "3540352207 2045426403 63912525\n" +
            "2879366909 3356847577 67075608\n" +
            "868611408 858081124 224160766\n" +
            "2304858397 2525185867 55003581\n" +
            "189640733 280695139 100931136\n" +
            "2144999688 3983682880 159858709\n" +
            "3374818325 3858616265 14108175\n" +
            "3604264732 2580189448 427645906\n" +
            "1730244179 535856806 2894582\n" +
            "4242091162 3634410314 52876134\n" +
            "4031910638 3872724440 110958440\n" +
            "1092772174 1116784935 90115688\n" +
            "1182887862 381626275 154230531\n" +
            "4149183732 3263940147 92907430\n" +
            "4142869078 3423923185 6314654\n" +
            "571267008 728392121 129689003\n" +
            "3315918322 2352914852 58900003\n" +
            "2359861978 3508777608 125632706\n" +
            "2735364270 2109338928 144002639\n" +
            "2946442517 2411814855 113371012\n" +
            "1733138761 1082241890 34543045\n" +
            "700956011 1600026409 167655397\n" +
            "3059813529 3041876971 222063176\n" +
            "2564034453 3687286448 171329817\n" +
            "3281876705 3007835354 34041617\n" +
            "0 538751388 189640733\n" +
            "3388926500 4143541589 151425707\n" +
            "1337118393 1206900623 393125786\n" +
            "\n" +
            "water-to-light map:\n" +
            "66525849 932008802 34502691\n" +
            "1231709999 161981088 108836128\n" +
            "4050378444 3046032039 195065028\n" +
            "1188304980 324179540 43405019\n" +
            "0 95455239 66525849\n" +
            "1134942656 270817216 53362324\n" +
            "4015087939 2401779423 35290505\n" +
            "3174436586 2144628864 257150559\n" +
            "3688283374 3968162731 326804565\n" +
            "101028540 367584559 564424243\n" +
            "665452783 23428765 72026474\n" +
            "2144628864 2437069928 302742058\n" +
            "1340546127 0 23428765\n" +
            "737479257 1714174561 397463399\n" +
            "3431587145 2789335810 256696229\n" +
            "4245443472 2739811986 49523824\n" +
            "1363974892 966511493 747663068\n" +
            "2447370922 3241097067 727065664\n" +
            "\n" +
            "light-to-temperature map:\n" +
            "3188351957 4202865263 58820659\n" +
            "583430260 717912118 192120954\n" +
            "1044551258 2246397764 71032709\n" +
            "3109547837 4261685922 33281374\n" +
            "1678878772 1586709546 87694921\n" +
            "1115583967 3604496785 152969541\n" +
            "3142829211 2200875018 45522746\n" +
            "2103724421 1412959073 173750473\n" +
            "3094755823 2836912864 14792014\n" +
            "4233716778 2851704878 61250518\n" +
            "1809783323 3254776949 293941098\n" +
            "570222212 2097755032 13208048\n" +
            "34744215 693464 72237295\n" +
            "1773265141 2502078476 36518182\n" +
            "775551214 4072807084 98261716\n" +
            "2718819720 511651563 117721319\n" +
            "873812930 4171068800 31796463\n" +
            "905609393 3933865219 138941865\n" +
            "373474927 3892288779 41576440\n" +
            "3040218555 3117948789 54537268\n" +
            "2397118702 2538596658 1887839\n" +
            "0 72930759 34744215\n" +
            "2277474894 1316613368 93303271\n" +
            "370955311 1409916639 2519616\n" +
            "1359408316 3757466326 134822453\n" +
            "2370778165 306806837 1167210\n" +
            "220512052 1412436255 522818\n" +
            "3335711852 1674404467 423350565\n" +
            "335173455 2743397480 35781856\n" +
            "3900016435 982913025 333700343\n" +
            "2399006541 2540484497 202912983\n" +
            "3816795945 2110963080 83220490\n" +
            "415051367 910033072 72879953\n" +
            "2663040982 3548718047 55778738\n" +
            "3759062417 2779179336 57733528\n" +
            "3247172616 629372882 88539236\n" +
            "1494230769 2317430473 184648003\n" +
            "1766573693 2194183570 6691448\n" +
            "2601919524 245685379 61121458\n" +
            "2371945375 220512052 25173327\n" +
            "221034870 3003810204 114138585\n" +
            "2836541039 307974047 203677516\n" +
            "487931320 3172486057 82290892\n" +
            "106981510 0 693464\n" +
            "1268553508 2912955396 90854808\n" +
            "\n" +
            "temperature-to-humidity map:\n" +
            "1844491325 2716144828 118858329\n" +
            "1004942401 2971501799 229549152\n" +
            "696973964 238546929 19842755\n" +
            "716816719 119302258 119244671\n" +
            "444146335 2339344684 80152617\n" +
            "3752420807 853580623 112964826\n" +
            "3736479208 2933101125 15941599\n" +
            "1822411864 805752927 11014046\n" +
            "3183816206 2835003157 98097968\n" +
            "3538508914 2576089466 88076349\n" +
            "1833425910 816766973 11065415\n" +
            "3865385633 2664165815 51979013\n" +
            "1706894195 1592117663 89769434\n" +
            "2892814110 3354360228 291002096\n" +
            "2450334080 3645362324 65003481\n" +
            "3934652728 3721018678 66888233\n" +
            "3285923313 2419497301 85776839\n" +
            "3917364646 2257358228 17288082\n" +
            "3371700152 2090549466 166808762\n" +
            "524298952 633077915 172675012\n" +
            "1600852292 966545449 106041903\n" +
            "2283983708 620036820 13041095\n" +
            "2176983704 2274646310 64698374\n" +
            "2515337561 1072587352 32448957\n" +
            "846714263 1105036309 42935019\n" +
            "3719859664 603417276 16619544\n" +
            "2547786518 258389684 345027592\n" +
            "0 1147971328 444146335\n" +
            "1963349654 3787906911 213634050\n" +
            "836061390 3710365805 10652873\n" +
            "889649282 0 115293119\n" +
            "2241682078 1681887097 42301630\n" +
            "3281914174 115293119 4009139\n" +
            "2297024803 3201050951 153309277\n" +
            "1796663629 827832388 25748235\n" +
            "3626585263 2505274140 70815326\n" +
            "1234491553 1724188727 366360739\n" +
            "3697400589 2949042724 22459075\n" +
            "\n" +
            "humidity-to-location map:\n" +
            "3693038281 1946208152 169064741\n" +
            "3025397429 1673895501 272312651\n" +
            "2522027478 1111558812 503369951\n" +
            "3862103022 3729735566 432864274\n" +
            "1111558812 2115272893 1374715990\n" +
            "3356676818 3489988883 239746683\n" +
            "3297710080 1614928763 58966738\n" +
            "2486274802 4162599840 35752676\n" +
            "3596423501 4198352516 96614780"
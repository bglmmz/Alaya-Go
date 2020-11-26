package network.platon.contracts.wasm;

import com.alaya.abi.wasm.WasmFunctionEncoder;
import com.alaya.abi.wasm.datatypes.WasmFunction;
import com.alaya.crypto.Credentials;
import com.alaya.protocol.Web3j;
import com.alaya.protocol.core.RemoteCall;
import com.alaya.protocol.core.methods.response.TransactionReceipt;
import com.alaya.rlp.wasm.datatypes.Uint64;
import com.alaya.tx.TransactionManager;
import com.alaya.tx.WasmContract;
import com.alaya.tx.gas.GasProvider;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.alaya.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.2.0.
 */
public class ContractCrossCallStorageVector extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001651160027f7f0060017f0060017f017f60027f7f017f60037f7f7f0060037f7f7f017f60000060047f7f7f7f017f60027f7e0060047f7f7f7f0060017f017e60047f7f7e7e0060037e7e7f006000017f60077f7f7f7f7f7f7f017f60017e017f60027e7e017f02bb020e03656e760c706c61746f6e5f70616e6963000603656e760d726c705f6c6973745f73697a65000203656e760f706c61746f6e5f726c705f6c697374000403656e760e726c705f62797465735f73697a65000303656e7610706c61746f6e5f726c705f6279746573000403656e760d726c705f753132385f73697a65001003656e760f706c61746f6e5f726c705f75313238000c03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000d03656e7610706c61746f6e5f6765745f696e707574000103656e7617706c61746f6e5f6765745f73746174655f6c656e677468000303656e7610706c61746f6e5f6765745f7374617465000703656e7610706c61746f6e5f7365745f7374617465000903656e760b706c61746f6e5f63616c6c000e03656e760d706c61746f6e5f72657475726e0000035554060b030203030800000800000501000202040401000804000302050300030001030000030102000507010504020605040a0a010201020200000001060701000700010500030305040001020f01000200060202090405017001010105030100020608017f0141d089040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000e0f5f5f66756e63735f6f6e5f65786974004906696e766f6b65003b0af378540400105e0bf617020d7f017e230041d0016b22042400200441c0016a4180081010220628020420042d00c0012205410176200541017122071b21052006280208200641016a20071b210642a5c688a1c89ca7f94b21110340200504402005417f6a21052006300000201142b383808080207e852111200641016a21060c010b0b200441d8006a10112105200441306a2001101221062005410210132105200441286a4100360200200441206a4200370300200441186a420037030020044200370310200441106a20111014200441106a20061015200520042802101016200520111017200520061018027f02400240200528020c200541106a280200460440200541046a2106200528020021010c010b200541046a2106100020052802002101200528020c2005280210470d010b20010c010b100020052802000b210720044100360208200442003703000240200720062802006a20016b2206450d0020042006101920064101480d002004200428020420012006101a20066a3602040b200441106a410472101b200528020c22060440200520063602100b200441f0006a418c081010210f2000280208200041016a220d20002d0000220541017122061b21082000280204200541017620061b210a41002105410121014100210702400340200141017141002005200a491b0440200520086a2d00002206415f6a41ff017141de004921012007200641bf7f6a41ff0171411a4972210720092006419f7f6a41ff0171411a49722109200541016a21050c0105024020012007200971410173712107200a450d00200a210503402005450d01200520086a21012005417f6a220621052001417f6a2d00004131470d000b0c030b0b0b417f21060b0240024002402007410171450d00200641076a200a4b0d00200641016a4102490d00200a41da004b0d00410021052004410036026020044200370358200441d8006a200a2006417f7322096a101c4101210702400240024003402005200028020420002d00002201410176200141017122011b20096a4f044002402007410171450d05200441c0016a101d220541016a210e410021010340200120064604402005280204220920042d00c00122064101762208200641017122071b2201200f28020420042d00702206410176200641017122061b470d05200f280208200f41016a20061b210620070d0220082101200e210703402001450440200821090c080b20072d000020062d0000470d06200641016a2106200741016a21072001417f6a21010c000b00052000280208200d20002d00004101711b20016a2c000022084120722008200841bf7f6a411a491b210c024002400240027f20042d00c001220a4101712210450440410a2109200a4101760c010b2005280200220a417e71417f6a210920052802040b220720094604402005280208200e200a4101711b210b416f210a200941e6ffffff074d0440410b20094101742208200941016a220a200a2008491b220841106a4170712008410b491b210a0b200a101e2208200b2009101f2005200a410172360200200520083602080c010b2010450d01200528020821080b2005200741016a3602040c010b2004200741017441026a3a00c001200e21080b200720086a220741003a00012007200c3a0000200141016a21010c010b000b000b05200428025820056a2000280208200d20011b20066a20056a41016a2d00004190086a2d000022013a00002007200141ff0147712107200541016a21050c010b0b2001450d012005280208210703402001450d0220072d000020062d0000470d01200641016a2106200741016a21072001417f6a21010c000b000b200441386a4200370300200441406b410036020020044200370330200441003a004420042802582205450d032004200536025c0c030b410021062004410036021820044200370310200441106a2009410174410172101c03402006200528020420042d00c0012201410176200141017122011b2207490440200428021020066a2005280208200e20011b20066a2d000022014105763a00002004280210200528020420042d00c001220741017620074101711b6a20066a41016a2001411f713a0000200641016a21060c010b0b200428021020076a41003a0000200428021421010240200428025c2206200428025822056b22074101480d0020072004280218220820016b4c0440034020052006460d02200120052d00003a00002004200428021441016a2201360214200541016a21050c000b000b200441406b200441186a360200410021092004410036023c2001200428021022006b210a200120076a20006b2207200820006b2208410174220020002007491b41ffffffff07200841ffffffff03491b220804402008101e21090b2004200936023020042009200a6a22073602382004200820096a36023c20042007360234200441306a4104722109034020052006470440200720052d00003a00002004200428023841016a2207360238200541016a21050c010b0b200428021020012009102002402004280214220620016b220541004c0440200428023821010c010b2004200428023820012005101a20056a2201360238200428021421060b2004280210210520042004280234360210200420053602342004200136021420042006360238200428021821062004200428023c3602182004200636023c20042005360230200441306a1021200428021421010b200442003702142004280210210620044100360210200120066b21014101210503402001044020062d000041002005411d764101716b41b3c5d1d0027141002005411c764101716b41dde788ea037141002005411b764101716b41fab384f5017141002005411a764101716b41ed9cc2b20271410020054119764101716b41b2afa9db0371200541057441e0ffffff037173737373737321052001417f6a2101200641016a21060c010b0b20054101470d004100210b200441003602a00120044200370398012004410036021820044200370310027f4100200428025c417a6a2201200428025822056b2206450d001a200441106a200610190340200120054704402004280214220620052d00003a00002004200641016a360214200541016a21050c010b0b2004280210210b20042802140b200b6b2110200441a0016a210d41002105410021084100210c02400340200c201046044002402008410820056b7441ff0171452005410548712105200b04402004200b3602140b20050d0020042802980121050c030b05200b200c6a2d0000200841057441e01f71722108200541056a21050340200541084e04402008200541786a2205762101200428029c01220720042802a0012209490440200720013a00002004200428029c0141016a36029c010c02052004200d360240410021062004410036023c200720042802980122006b220741016a220a200920006b220941017422002000200a491b41ffffffff07200941ffffffff03491b220904402009101e21060b20042006360230200620076a220720013a00002004200620096a36023c200420073602342004200741016a36023820044198016a200441306a1022200441306a10210c020b000b0b200c41016a210c0c010b0b200428029c0120042802980122056b4114470d00200441206a4100360200200441186a42003703002004420037031041002105034020054114470440200441106a20056a41003a0000200541016a21050c010b0b200428029c0120042802980122066b2101410021050340024020012005460d00200541134b0d00200441106a20056a200520066a2d00003a0000200541016a21050c010b0b200441406b200441206a280200360200200441386a200441186a29030037030020042004290310370330200441013a0044200604402004200636029c010b2004280258220504402004200536025c0b200441106a20021023200441d8006a20031023200441306a20042802002205200428020420056b20042802102206200428021420066b20042802582206200428025c20066b100c1a2004280258220604402004200636025c0b20042802102206450d04200420063602140c040b2005450d002004200536029c010b20042802582205450d002004200536025c0b200441386a4200370300200441406b410036020020044200370330200441003a00440b200428020021050b20050440200420053602040b200441d0016a24000b910101027f20004200370200200041086a410036020020012102024003402002410371044020022d0000450d02200241016a21020c010b0b2002417c6a21020340200241046a22022802002203417f73200341fffdfb776a7141808182847871450d000b0340200341ff0171450d01200241016a2d00002103200241016a21020c000b000b20002001200220016b102420000b29002000410036020820004200370200200041001025200041146a41003602002000420037020c20000b25002000200110261a2000410c6a2001410c6a10261a200041186a200141186a10261a20000b9d0201057f2001044020002802042105200041106a2802002202200041146a280200220349044020022001ad2005ad422086843702002000200028021041086a36021020000f0b027f41002002200028020c22046b410375220641016a2202200320046b2203410275220420042002491b41ffffffff01200341037541ffffffff00491b2204450d001a2004410374101e0b2102200220064103746a22032001ad2005ad4220868437020020032000280210200028020c22066b22016b2105200220044103746a2102200341086a2103200141014e0440200520062001101a1a0b20002002360214200020033602102000200536020c20000f0b200041001001200028020422016a102c41004100200120002802006a10022000102d20000b880102027f017e4101210220014280015a044041002102034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002102720026a0520020b41016a21020b200041186a28020022030440200041086a280200200041146a2802002003102821000b2000200028020020026a3602000b4001017f230041206b2202240020004100102922002001102a2000200241106a2001410c6a1026102b2002200141186a1026102b410110291a200241206a24000b1300200028020820014904402000200110250b0b2801017f2000420020011005200028020422026a102c42002001200220002802006a10062000102d0b820201057f230041a0016b220224002000410310132100200241d8006a4100360200200241d0006a4200370300200241c8006a420037030020024200370340200241406b2001102a200241406b200241306a2001410c6a22031026102b200241206a200141186a22041026102b2105200020022802401016200041011013210020024198016a410036020020024190016a420037030020024188016a4200370300200242003703800120024180016a200241f0006a20011026102b2106200020022802800110162000200241e0006a20011026102e2101200641046a101b2001200241106a20031026102e200220041026102e1a200541046a101b200241a0016a24000b2001017f20002001101e2202360200200020023602042000200120026a3602080bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bea0101047f230041106b22042400200028020422012000280210220241087641fcffff07716a2103027f410020012000280208460d001a2003280200200241ff07714102746a0b2101200441086a2000102f200428020c210203400240200120024604402000410036021420002802082103200028020421010340200320016b41027522024103490d022000200141046a22013602040c000b000b200141046a220120032802006b418020470d0120032802042101200341046a21030c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b200020011030200441106a24000bfa0101057f230041206b22022400024020002802042203200028020022046b22052001490440200028020820036b200120056b22044f04400340200341003a00002000200028020441016a22033602042004417f6a22040d000c030b000b2000200110312106200241186a200041086a3602002002410036021441002101200604402006101e21010b200220013602082002200120056a22033602102002200120066a3602142002200336020c0340200341003a00002002200228021041016a22033602102004417f6a22040d000b2000200241086a1022200241086a10210c010b200520014d0d002000200120046a3602040b200241206a24000b190020004200370200200041086a41003602002000103220000b0b002000410120001b103a0b100020020440200020012002101a1a0b0b270020022002280200200120006b22016b2202360200200141014e0440200220002001101a1a0b0b2b01027f200028020821012000280204210203402001200247044020002001417f6a22013602080c010b0b0b6701017f20002802002000280204200141046a1020200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b6302017f017e20012103034020035045044020034208882103200241016a21020c010b0b200041003602082000420037020020002002101c2000280204417f6a21020340200150450440200220013c00002002417f6a2102200142088821010c010b0b0b5a01027f02402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204101e21032000200236020420002004410172360200200020033602080b200320012002101f200220036a41003a00000b2f01017f200028020820014904402001103a20002802002000280204101a210220002001360208200020023602000b0b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204102420000b1e01017f03402000044020004108762100200141016a21010c010b0b20010b25002000200120026a417f6a220241087641fcffff07716a280200200241ff07714102746a0bc30c02077f027e230041306b22042400200041046a2107027f20014101460440200041086a280200200041146a280200200041186a220228020022031028280200210120022003417f6a360200200710334180104f044020072000410c6a280200417c6a10300b200141384f047f2001102720016a0520010b41016a2102200041186a28020022010440200041086a280200200041146a280200200110280c020b20000c010b0240200710330d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021032001200241046a360200200420033602182007200441186a10340c010b2000410c6a2802002202200041086a2802006b4102752203200041106a2205280200220620002802046b2201410275490440418020101e2105200220064704400240200028020c220120002802102202470d0020002802082203200028020422064b04402000200320012003200320066b41027541016a417e6d41027422026a1035220136020c2000200028020820026a3602080c010b200441186a200220066b2201410175410120011b22012001410276200041106a10362102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021037200028020c21010b200120053602002000200028020c41046a36020c0c020b02402000280208220120002802042202470d00200028020c2203200028021022064904402000200120032003200620036b41027541016a41026d41027422026a103822013602082000200028020c20026a36020c0c010b200441186a200620026b2201410175410120011b2201200141036a410276200041106a10362102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021037200028020821010b2001417c6a2005360200200020002802082201417c6a22023602082002280200210220002001360208200420023602182007200441186a10340c010b20042001410175410120011b2003200510362102418020101e2106024020022802082201200228020c2203470d0020022802042205200228020022084b04402002200520012005200520086b41027541016a417e6d41027422036a103522013602082002200228020420036a3602040c010b200441186a200320086b2201410175410120011b22012001410276200241106a280200103621032002280208210520022802042101034020012005470440200328020820012802003602002003200328020841046a360208200141046a21010c010b0b20022902002109200220032902003702002003200937020020022902082109200220032902083702082003200937020820031037200228020821010b200120063602002002200228020841046a360208200028020c2105034020002802082005460440200028020421012000200228020036020420022001360200200228020421012002200536020420002001360208200029020c21092000200229020837020c2002200937020820021037052005417c6a210502402002280204220120022802002203470d0020022802082206200228020c22084904402002200120062006200820066b41027541016a41026d41027422036a103822013602042002200228020820036a3602080c010b200441186a200820036b2201410175410120011b2201200141036a4102762002280210103621062002280208210320022802042101034020012003470440200428022020012802003602002004200428022041046a360220200141046a21010c010b0b20022902002109200220042903183702002002290208210a20022004290320370208200420093703182004200a37032020061037200228020421010b2001417c6a200528020036020020022002280204417c6a3602040c010b0b0b200441186a2007102f200428021c410036020041012102200041186a0b2201200128020020026a360200200441306a240020000b2701017f230041106b22022400200041001029200220011026102b410110291a200241106a24000ba10101037f41012103024002400240200128020420012d00002202410176200241017122041b220241014d0440200241016b0d032001280208200141016a20041b2c0000417f4c0d010c030b200241374b0d010b200241016a21030c010b2002102720026a41016a21030b027f200041186a28020022010440200041086a280200200041146a280200200110280c010b20000b2201200128020020036a36020020000b3601017f200028020820014904402001103a20002802002000280204101a210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210016a102c200120002802006a22012002200110020c010b0b0b4e01037f20002001280208200141016a20012d0000220241017122031b22042001280204200241017620031b22011003200028020422026a102c20042001200220002802006a10042000102d20000b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b2e01017f2001200028020820002802006b2200410174220220022001491b41ffffffff07200041ffffffff03491b0b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2203470d0020002802042204200028020022064b04402000200420022004200420066b41027541016a417e6d41027422036a103522023602082000200028020420036a3602040c010b200541086a200320066b2202410175410120021b220220024102762000410c6a10362103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b20002902002107200020032902003702002003200737020020002902082107200020032902083702082003200737020820031037200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110390b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274101e21040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110390b20020b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002101a1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b9b0101047f230041106b220124002001200036020c2000047f41cc09200041086a2202411076220041cc092802006a220336020041c80941c809280200220420026a41076a417871220236020002400240200341107420024d044041cc09200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104101a41086a0541000b2100200141106a240020000b9a0302057f017e230041c0016b22002400105e10072201103a22021008200041406b200020022001103c22014100103d02400240200041406b103e2205500d00419009103f200551044020011040200041406b104110420c020b419509103f2005510440200041406b101d2102200041cc006a10432103200042003703782000420037037020011044410547044010000b200041013602a80120002001360280012000200041a8016a36028401200041186a20014101103d200041186a20021045200020002802a80141016a22043602a801200041186a20012004103d200041186a20031046200020002802a80141016a3602a80120004180016a200041f0006a104720004180016a200041f8006a1047200041186a10412101200041a8016a2002102620004180016a2003101220002903702000290378100f200042003703b801200041b8016a1048200110420c020b41a609103f2005520d0020011040200041406b104121012000200041dc006a28020020002802586b41246dad370318200041186a1048200110420c010b10000b1049200041c0016a24000b0c00200020012002411c104a0bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001105b20012003280208200328020c105336020c20032001105b410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b2000200628020020044114104a1a200341106a24000f0b20032001105b41002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004105310612001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b870202047f017e230041106b220324002000104b024002402000280204450d002000104b0240200028020022022c0000220141004e044020010d010c020b200141807f460d00200141ff0171220441b7014d0440200028020441014d04401000200028020021020b20022d00010d010c020b200441bf014b0d012000280204200141ff017141ca7e6a22014d04401000200028020021020b200120026a2d0000450d010b2000280204450d0020022d000041c001490d010b10000b200341086a2000104c200328020c220041094f044010000b200328020821010340200004402000417f6a210020013100002005420886842105200141016a21010c010b0b200341106a240020050b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b0e0020001044410147044010000b0bfd06010c7f230041c0016b22042400200042003702182000428aa4bedd86c3aeee583703102000410036020820004200370200200041206a4100360200200441306a1011220620002903101017200628020c200641106a28020047044010000b200041186a21072000411c6a2108024020062802002202200628020422031009220a450d002004410036022820044200370320200441206a200a101c2002200320042802202205200428022420056b100a417f47044002400240200441086a2004280220220141016a20042802242001417f736a103c2202280204450d0020022802002d000041c001490d002002104421012000280220200028021822036b41246d20014904402007200441c8006a2001200028021c20036b41246d200041206a104d2201104e2001104f0b20044198016a200241011050210120044188016a2002410010502105200041206a210b20012802042102034020052802042002464100200128020822032005280208461b0d02200441f0006a20022003411c104a200441c8006a1043220210460240200028021c220320002802204904402003200210512008200828020041246a3602000c010b200441a8016a2007200320072802006b41246d220341016a10522003200b104d210320042802b00120021051200420042802b00141246a3602b00120072003104e2003104f0b20012001280204220220012802086a410020021b22023602042001280200220304402001200336020820022003105321092001027f200128020422024504404100210341000c010b4100210341002001280208220c2009490d001a200c20092009417f461b210320020b2202ad2003ad42208684370204200141002001280200220920036b2203200320094b1b3602000c0105200141003602080c010b000b000b10000b200a21010b20042802202202450d00200420023602240b200628020c22020440200620023602100b024020010d0020002802042203200028020022026b41246d22052000280220200028021822016b41246d4d04402005200828020020016b41246d22064b044020022002200641246c6a2205200110541a20052003200810550c020b2007200220032001105410560c010b200104402007105720004100360220200042003702180b20002007200510522205105822013602182000200136021c20002001200541246c6a36022020022003200810550b200441c0016a240020000bfc0301097f230041d0006b22032400200341186a10112204200029031010591016200420002903101017200428020c200441106a28020047044010000b2004280204210720042802002108200310112101200341c8006a4100360200200341406b4200370300200341386a420037030020034200370330027f20002802182000411c6a2802004604402003410136023041010c010b200341306a410010292105200028021c210620002802182102037f2002200646047f2005410110291a200328023005200520021015200241246a21020c010b0b0b2106200341306a410472101b4101101e220241fe013a0000200128020c200141106a28020047044010000b2001280204220541016a220920012802084b047f20012009102520012802040520050b20012802006a20024101101a1a2001200128020441016a3602042001200241016a200620026b6a10162001200028021c20002802186b41246d10132106200028021c210520002802182102034020022005470440200620021018200241246a21020c010b0b0240200128020c2001280210460440200128020021020c010b100020012802002102200128020c2001280210460d0010000b2008200720022001280204100b200128020c22020440200120023602100b200428020c22020440200420023602100b200041186a105a2000105a200341d0006a24000b19002000101d1a2000410c6a101d1a200041186a101d1a20000b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a2000105b200128020c210003402000450d01200141002001280208220320032000105322046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020bf40201057f230041206b22022400024002402000280204044020002802002d000041c001490d010b200241086a101d1a0c010b200241186a2000104c2000105c21030240024002400240200228021822000440200228021c220520034f0d010b41002100200241106a410036020020024200370308410021050c010b200241106a4100360200200242003703082000200520032003417f461b22046a21052004410a4b0d010b200220044101743a0008200241086a41017221030c010b200441106a4170712206101e21032002200436020c20022006410172360208200220033602100b03402000200546450440200320002d00003a0000200341016a2103200041016a21000c010b0b200341003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141003602000b20012002290308370200200141086a200241106a280200360200200241086a1032200241206a24000b5e01017f230041306b22022400200220004100103d200241186a20024100103d200241186a20011045200241186a20004101103d200241186a2001410c6a1045200241186a20004102103d200241186a200141186a1045200241306a24000b4601017f230041206b22022400200241086a20002802002000280204280200103d2001200241086a103e37030020002802042200200028020041016a360200200241206a24000b5f01027f230041206b22022400200241086a10112201200029030010591016200120002903001017200128020c200141106a28020047044010000b20012802002001280204100d200128020c22000440200120003602100b200241206a24000b880101037f41b809410136020041bc092802002100034020000440034041c00941c0092802002201417f6a2202360200200141014845044041b8094100360200200020024102746a22004184016a280200200041046a28020011010041b809410136020041bc0928020021000c010b0b41c009412036020041bc09200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000105f20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000105f20024d0d0020034104710440100020000f0b200042003702000b20000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bd50101047f2001105c2204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b4c01017f2000410036020c200041106a2003360200200104402001105821040b2000200436020020002004200241246c6a220236020820002004200141246c6a36020c2000200236020420000b900101027f2000280204210220002802002103034020022003464504402001280204415c6a2002415c6a2202105120012001280204415c6a3602040c010b0b200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2b01027f200028020821012000280204210203402001200247044020002001415c6a22013602080c010b0b0be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001105b20004100200428020c2201200428020822022001105322032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b620020002001290200370200200041086a200141086a28020036020020011032200041146a200141146a2802003602002000200129020c37020c2001410c6a1032200041206a200141206a28020036020020002001290218370218200141186a10320b2f01017f2001200028020820002802006b41246d2200410174220220022001491b41c7e3f138200041e3f1b81c491b0b2701017f230041206b22022400200241086a200020014114104a105f2100200241206a240020000b3e000340200020014645044020022000105d2002410c6a2000410c6a105d200241186a200041186a105d200241246a2102200041246a21000c010b0b20020b2e00034020002001464504402002280200200010121a2002200228020041246a360200200041246a21000c010b0b0b0900200020013602040b0b002000200028020010560b0900200041246c101e0b4f01027f230041206b22012400200141186a4100360200200141106a4200370300200141086a420037030020014200370300200120001014200128020021022001410472101b200141206a240020020b0e0020002802000440200010570b0b2101017f2001105c220220012802044b044010000b2000200120011060200210610bff0201037f200028020445044041000f0b2000104b41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b8c0201047f20002001470440200128020420012d00002202410176200241017122041b2102200141016a210320012802082105410a21012005200320041b210420002d0000410171220304402000280200417e71417f6a21010b200220014d0440027f2003044020002802080c010b200041016a0b21012002044020012004200210390b200120026a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b416f2103200141e6ffffff074d0440410b20014101742201200220022001491b220141106a4170712001410b491b21030b2003101e220120042002101f200020023602042000200341017236020020002001360208200120026a41003a00000b0b3501017f230041106b220041d0890436020c41c409200028020c41076a417871220036020041c809200036020041cc093f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010602000105c6a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0bbd0101004180080bb5016164645f6d6573736167650061747800ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff0fff0a1115141a1e0705ffffffffffffff1dff180d19090817ff12161f1b13ff010003100b1c0c0e060402ffffffffffff1dff180d19090817ff12161f1b13ff010003100b1c0c0e060402ffffffffff696e69740063616c6c5f6164645f6d657373616765006765745f766563746f725f73697a65";

    public static String BINARY = BINARY_0;

    public static final String FUNC_CALL_ADD_MESSAGE = "call_add_message";

    public static final String FUNC_GET_VECTOR_SIZE = "get_vector_size";

    protected ContractCrossCallStorageVector(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected ContractCrossCallStorageVector(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<ContractCrossCallStorageVector> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractCrossCallStorageVector.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ContractCrossCallStorageVector> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractCrossCallStorageVector.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ContractCrossCallStorageVector> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractCrossCallStorageVector.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<ContractCrossCallStorageVector> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ContractCrossCallStorageVector.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> call_add_message(String target_address, My_message one_message, Uint64 value, Uint64 gas) {
        final WasmFunction function = new WasmFunction(FUNC_CALL_ADD_MESSAGE, Arrays.asList(target_address,one_message,value,gas), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> call_add_message(String target_address, My_message one_message, Uint64 value, Uint64 gas, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_CALL_ADD_MESSAGE, Arrays.asList(target_address,one_message,value,gas), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Uint64> get_vector_size() {
        final WasmFunction function = new WasmFunction(FUNC_GET_VECTOR_SIZE, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public static ContractCrossCallStorageVector load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new ContractCrossCallStorageVector(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static ContractCrossCallStorageVector load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new ContractCrossCallStorageVector(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static class Message {
        public String head;
    }

    public static class My_message {
        public Message baseClass;

        public String body;

        public String end;
    }
}

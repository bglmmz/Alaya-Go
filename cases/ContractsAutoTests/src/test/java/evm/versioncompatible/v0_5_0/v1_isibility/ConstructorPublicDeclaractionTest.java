package evm.versioncompatible.v0_5_0.v1_isibility;

import evm.beforetest.ContractPrepareTest;
import network.platon.autotest.junit.annotations.DataSource;
import network.platon.autotest.junit.enums.DataSourceType;
import network.platon.contracts.ConstructorPublicDeclaraction;
import org.junit.Before;
import org.junit.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;


/**
 * @title 构造函数可见性必须显示声明public
 * @description:
 * @author: hudenian
 * @create: 2019/12/26
 */
public class ConstructorPublicDeclaractionTest extends ContractPrepareTest {


    //链上函数初始值
    private String initValue;

    //新增值
    private String addValue;

    @Before
    public void before() {
        this.prepare();
        initValue = driverService.param.get("initValue");
        addValue = driverService.param.get("addValue");
    }



    @Test
    @DataSource(type = DataSourceType.EXCEL, file = "test.xls", sheetName = "Sheet1",
            author = "hudenian", showName = "ConstructorPublicDeclaractionTest-可见性测试", sourcePrefix = "evm")
    public void constructPublicTest() {
        try {

            ConstructorPublicDeclaraction constructorPublicDeclaraction = ConstructorPublicDeclaraction.deploy(web3j, transactionManager, provider, chainId,  new BigInteger(initValue)).send();

            String contractAddress = constructorPublicDeclaraction.getContractAddress();
            TransactionReceipt tx = constructorPublicDeclaraction.getTransactionReceipt().get();

            collector.logStepPass("链上函数的初始值为："+initValue);

            collector.logStepPass("FunctionDeclaraction deploy successfully.contractAddress:" + contractAddress + ", hash:" + tx.getTransactionHash());
            collector.logStepPass("deploy gas used:" + constructorPublicDeclaraction.getTransactionReceipt().get().getGasUsed());

            TransactionReceipt transactionReceipt =constructorPublicDeclaraction.update(new BigInteger(addValue)).send();

            collector.logStepPass("FunctionDeclaraction update_public successful.transactionHash:" + transactionReceipt.getTransactionHash());
            collector.logStepPass( "currentBlockNumber:" + transactionReceipt.getBlockNumber());

            String afterValue = constructorPublicDeclaraction.getCount().send().toString();
            collector.logStepPass("链上函数的执行update后的值为："+afterValue);

            collector.assertEqual(String.valueOf(Integer.valueOf(initValue)+Integer.valueOf(addValue)),afterValue);
        } catch (Exception e) {
            collector.logStepFail("ConstructorPublicDeclaractionTest process fail.", e.toString());
            e.printStackTrace();
        }
    }


}

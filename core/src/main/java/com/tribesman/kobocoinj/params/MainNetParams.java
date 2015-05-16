/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tribesman.kobocoinj.params;

import com.tribesman.kobocoinj.core.NetworkParameters;
import com.tribesman.kobocoinj.core.Sha256Hash;
import com.tribesman.kobocoinj.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);
        dumpedPrivateKeyHeader = 163;
        addressHeader = 35;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 9011;
        packetMagic= 0xa1a0a2a3L;
        genesisBlock.setDifficultyTarget(0x1e0fffffL);
        genesisBlock.setTime(1421090888L);
        genesisBlock.setNonce(219702L);
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = 350000000;
        spendableCoinbaseDepth = 50;
        String genesisHash = genesisBlock.getHashAsString();
	java.util.logging.Logger.getLogger("mytag").info("genesishash = " + genesisHash);
        checkState(genesisHash.equals("00000c98be708f9ff86319738d4ce8778f1db7ce140d2d665cca9281eef433bd"), genesisHash);

        checkpoints.put(19080, new Sha256Hash("0000000004f7c45320983a9ef6343d1279e899e3e003fcc5f9724aa8f1aef321"));
        checkpoints.put(30583, new Sha256Hash("f73a28499ff1adedcf9fd0fbd61852e938a102ed9ba771187340c2e78e915e7c"));
        checkpoints.put(99999, new Sha256Hash("fea5083694e5a9ac9a51e478d2bbf01d1369cf8ea0293b2be37ca6c124acca7a"));

        dnsSeeds = new String[] {
                "dns1.kobocoin.com", "dns2.kobocoin.com"
        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}

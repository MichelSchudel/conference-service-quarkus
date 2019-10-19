package org.acme;

import io.quarkus.test.junit.SubstrateTest;

@SubstrateTest
public class NativePersonResourceIT extends PersonResourceTest {

    // Execute the same tests but in native mode.
}
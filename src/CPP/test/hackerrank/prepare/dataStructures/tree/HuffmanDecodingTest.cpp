#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_HUFFMAN_DECODING_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_HUFFMAN_DECODING_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/HuffmanDecoding.cpp"  // NOLINT : Ignore .cpp import

TEST(HuffmanDecodingTest, description) {
    testing::internal::CaptureStdout();
    HuffmanDecoding::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HuffmanDecodingTest, height_1) {
    auto expectedEncrypted = "01101110100010101101110";
    auto sourceDecode = "ABRACADABRA\n";
    auto source = "ABRACADABRA";
    auto root = HuffmanDecoding::generateTree(source);
    auto encrypted = HuffmanDecoding::encode_huff(root, source);
    EXPECT_EQ(expectedEncrypted, encrypted);
    testing::internal::CaptureStdout();
    HuffmanDecoding::decode_huff(root, encrypted);
    EXPECT_EQ(sourceDecode, testing::internal::GetCapturedStdout());
    HuffmanDecoding::deleteTree(&root);
}

TEST(HuffmanDecodingTest, height_2) {
    auto expectedEncrypted = "1001011";
    auto sourceDecode = "ABACA\n";
    auto source = "ABACA";
    auto root = HuffmanDecoding::generateTree(source);
    auto encrypted = HuffmanDecoding::encode_huff(root, source);
    EXPECT_EQ(expectedEncrypted, encrypted);
    testing::internal::CaptureStdout();
    HuffmanDecoding::decode_huff(root, encrypted);
    EXPECT_EQ(sourceDecode, testing::internal::GetCapturedStdout());
    HuffmanDecoding::deleteTree(&root);
}

TEST(HuffmanDecodingTest, height_3) {
    auto expectedEncrypted = "001000110110011110000101011101110101101011001111000";
    auto sourceDecode = "Rumpelstiltskin\n";
    auto source = "Rumpelstiltskin";
    auto root = HuffmanDecoding::generateTree(source);
    auto encrypted = HuffmanDecoding::encode_huff(root, source);
    EXPECT_EQ(expectedEncrypted, encrypted);
    testing::internal::CaptureStdout();
    HuffmanDecoding::decode_huff(root, encrypted);
    EXPECT_EQ(sourceDecode, testing::internal::GetCapturedStdout());
    HuffmanDecoding::deleteTree(&root);
}

TEST(HuffmanDecodingTest, height_4) {
    auto expectedEncrypted = "111100010101000100110111101000000110100010010101011101100100000"
                             "011110111110011011101101111100110111010100110111010110010000001"
                             "111011111001101110110001001010101111011111001101110010000001110"
                             "1111";
    auto sourceDecode = "howmuchwoodwouldawoodchuckchuckifawoodchuckcouldchuckwood?\n";
    auto source = "howmuchwoodwouldawoodchuckchuckifawoodchuckcouldchuckwood?";
    auto root = HuffmanDecoding::generateTree(source);
    auto encrypted = HuffmanDecoding::encode_huff(root, source);
    EXPECT_EQ(expectedEncrypted, encrypted);
    testing::internal::CaptureStdout();
    HuffmanDecoding::decode_huff(root, encrypted);
    EXPECT_EQ(sourceDecode, testing::internal::GetCapturedStdout());
    HuffmanDecoding::deleteTree(&root);
}

#endif
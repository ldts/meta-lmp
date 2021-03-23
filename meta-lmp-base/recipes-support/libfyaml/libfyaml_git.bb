SUMMARY = "A fancy 1.2 YAML and JSON parser/writer."
HOMEPAGE = "https://github.com/pantoniou/libfyaml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=6399094fbc639a289cfca2d660c010aa"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = "git://github.com/pantoniou/libfyaml.git"
SRCREV = "de89df9041b3a72b258680d6c8f6df31c5cee28a"

DEPENDS = " pkgconf "

S = "${WORKDIR}/git"

inherit autotools
PARALLEL_MAKE = ""

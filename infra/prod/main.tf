resource "random_uuid" "vault_role_id" {
}

resource "random_uuid" "vault_secret_id" {
}

module "dns" {
  source    = "git::https://github.com/nicholasM95/terraform-modules.git//modules/dns-cloudflare?ref=v1.1.6"
  ip        = var.server_ip
  name      = "api-skoda"
  host_name = var.host_name
}

module "application" {
  source           = "git::https://github.com/nicholasM95/terraform-modules.git//modules/k8s-helm-release?ref=v1.1.6"
  image_tag        = var.image_tag
  application_name = "api-skoda"
  namespace_name   = "skoda"
  helm_path        = "../../application"
  docker_config    = var.docker_config
}



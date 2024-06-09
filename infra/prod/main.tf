resource "random_uuid" "vault_role_id" {
}

resource "random_uuid" "vault_secret_id" {
}

module "vault" {
  source     = "git::https://github.com/nicholasM95/terraform-modules.git//modules/vault?ref=v1.1.5"
  role_id    = random_uuid.vault_role_id.result
  secret_id  = random_uuid.vault_secret_id.result
  vault_path = "api-skoda"
  data_json = jsonencode(
    {
      SENTRY_DSN = var.sentry_dsn,
    }
  )
}

module "dns" {
  source    = "git::https://github.com/nicholasM95/terraform-modules.git//modules/dns-cloudflare?ref=v1.1.5"
  ip        = var.server_ip
  name      = "api-skoda"
  host_name = var.host_name
}

module "application" {
  source           = "git::https://github.com/nicholasM95/terraform-modules.git//modules/k8s-helm-release?ref=v1.1.5"
  image_tag        = var.image_tag
  application_name = "api-skoda"
  namespace_name   = "skoda"
  helm_path        = "../../application"
  docker_config    = var.docker_config
  vault_uri        = var.vault_uri
  vault_role_id    = random_uuid.vault_role_id.result
  vault_secret_id  = random_uuid.vault_secret_id.result
}


